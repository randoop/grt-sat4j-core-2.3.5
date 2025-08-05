/*******************************************************************************
 * SAT4J: a SATisfiability library for Java Copyright (C) 2004, 2012 Artois University and CNRS
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU Lesser General Public License Version 2.1 or later (the
 * "LGPL"), in which case the provisions of the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of the LGPL, and not to allow others to use your version of
 * this file under the terms of the EPL, indicate your decision by deleting
 * the provisions above and replace them with the notice and other provisions
 * required by the LGPL. If you do not delete the provisions above, a recipient
 * may use your version of this file under the terms of the EPL or the LGPL.
 *
 * Based on the original MiniSat specification from:
 *
 * An extensible SAT solver. Niklas Een and Niklas Sorensson. Proceedings of the
 * Sixth International Conference on Theory and Applications of Satisfiability
 * Testing, LNCS 2919, pp 502-518, 2003.
 *
 * See www.minisat.se for the original solver in C++.
 *
 * Contributors:
 *   CRIL - initial API and implementation
 *******************************************************************************/
package org.sat4j.tools;

import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IConstr;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;

public class FullClauseSelectorSolver<T extends ISolver> extends
        AbstractClauseSelectorSolver<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final Map<Integer, IConstr> constrs = new HashMap<Integer, IConstr>();
    private final IVecInt lastClause = new VecInt();
    private IConstr lastConstr;
    private final boolean skipDuplicatedEntries;

    @SideEffectFree
    @Impure
    public FullClauseSelectorSolver(T solver, boolean skipDuplicatedEntries) {
        super(solver);
        this.skipDuplicatedEntries = skipDuplicatedEntries;
    }

    @Impure
    public IConstr addControlableClause(IVecInt literals)
            throws ContradictionException {
        if (this.skipDuplicatedEntries) {
            if (literals.equals(this.lastClause)) {
                return null;
            }
            this.lastClause.clear();
            literals.copyTo(this.lastClause);
        }
        int newvar = createNewVar(literals);
        literals.push(newvar);
        this.lastConstr = super.addClause(literals);
        if (this.lastConstr == null) {
            discardLastestVar();
        } else {
            this.constrs.put(newvar, this.lastConstr);
        }
        return this.lastConstr;
    }

    @Impure
    public IConstr addNonControlableClause(IVecInt literals)
            throws ContradictionException {
        return super.addClause(literals);
    }

    @Impure
    @Override
    public IConstr addClause(IVecInt literals) throws ContradictionException {
        return addControlableClause(literals);
    }

    @Impure
    @Override
    public int[] model() {
        int[] fullmodel = super.modelWithInternalVariables();
        if (fullmodel == null) {
            return null;
        }
        int[] model = new int[fullmodel.length - this.constrs.size()];
        int j = 0;
        for (int element : fullmodel) {
            if (this.constrs.get(Math.abs(element)) == null) {
                model[j++] = element;
            }
        }
        return model;
    }

    /**
     * 
     * @since 2.1
     */
    @SideEffectFree
    public Collection<IConstr> getConstraints() {
        return this.constrs.values();
    }

    @SideEffectFree
    @Override
    public Collection<Integer> getAddedVars() {
        return this.constrs.keySet();
    }

    @Pure
    public IConstr getLastConstr() {
        return lastConstr;
    }

    @Impure
    public void setLastConstr(IConstr lastConstr) {
        this.lastConstr = lastConstr;
    }

    @Pure
    public Map<Integer, IConstr> getConstrs() {
        return constrs;
    }

    @Pure
    public IVecInt getLastClause() {
        return lastClause;
    }

    @Pure
    public boolean isSkipDuplicatedEntries() {
        return skipDuplicatedEntries;
    }

}

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
package org.sat4j.tools.xplain;

import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IConstr;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.IteratorInt;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.GroupClauseSelectorSolver;
import org.sat4j.tools.SolverDecorator;

/**
 * Computation of MUS in a structured CNF, i.e. the clauses belong to
 * components, the explanation is to be extracted in terms of components.
 * 
 * @author daniel
 * 
 * @param <T>
 *            a subinterface to ISolver.
 * @since 2.1
 */
public class HighLevelXplain<T extends ISolver> extends
        GroupClauseSelectorSolver<T> implements Explainer {

    private IVecInt assump;

    private MinimizationStrategy xplainStrategy = new DeletionStrategy();

    @SideEffectFree
    @Impure
    public HighLevelXplain(T solver) {
        super(solver);
    }

    @Pure
    @Override
    public IConstr addAtLeast(IVecInt literals, int degree)
            throws ContradictionException {
        throw new UnsupportedOperationException();
    }

    @Pure
    @Override
    public IConstr addAtMost(IVecInt literals, int degree)
            throws ContradictionException {
        throw new UnsupportedOperationException();
    }

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * @since 2.2.4
     * @return
     * @throws TimeoutException
     */
    @Impure
    private IVecInt explanationKeys() throws TimeoutException {
        assert !isSatisfiable(this.assump);
        ISolver solver = decorated();
        if (solver instanceof SolverDecorator<?>) {
            solver = ((SolverDecorator<? extends ISolver>) solver).decorated();
        }
        return this.xplainStrategy.explain(solver, getVarToHighLevel(),
                this.assump);
    }

    @Impure
    public int[] minimalExplanation() throws TimeoutException {
        Collection<Integer> components = explain();
        int[] model = new int[components.size()];
        int i = 0;
        for (int c : components) {
            model[i++] = c;
        }
        Arrays.sort(model);
        return model;
    }

    /**
     * @since 2.1
     * @return
     * @throws TimeoutException
     */
    @Impure
    public Collection<Integer> explain() throws TimeoutException {
        IVecInt keys = explanationKeys();
        Collection<Integer> explanation = new HashSet<Integer>(keys.size());
        for (IteratorInt it = keys.iterator(); it.hasNext();) {
            explanation.add(getVarToHighLevel().get(it.next()));
        }
        return explanation;
    }

    /**
     * @since 2.1
     */
    @Impure
    public void cancelExplanation() {
        this.xplainStrategy.cancelExplanationComputation();
    }

    @Impure
    @Override
    public int[] findModel() throws TimeoutException {
        this.assump = VecInt.EMPTY;
        return super.findModel();
    }

    @Impure
    @Override
    public int[] findModel(IVecInt assumps) throws TimeoutException {
        this.assump = assumps;
        return super.findModel(assumps);
    }

    @Impure
    @Override
    public boolean isSatisfiable() throws TimeoutException {
        this.assump = VecInt.EMPTY;
        return super.isSatisfiable();
    }

    @Impure
    @Override
    public boolean isSatisfiable(boolean global) throws TimeoutException {
        this.assump = VecInt.EMPTY;
        return super.isSatisfiable(global);
    }

    @Impure
    @Override
    public boolean isSatisfiable(IVecInt assumps) throws TimeoutException {
        this.assump = assumps;
        return super.isSatisfiable(assumps);
    }

    @Impure
    @Override
    public boolean isSatisfiable(IVecInt assumps, boolean global)
            throws TimeoutException {
        this.assump = assumps;
        return super.isSatisfiable(assumps, global);
    }

    @Impure
    @Override
    public String toString(String prefix) {
        System.out.println(prefix
                + "High Level Explanation (MUS) enabled solver");
        System.out.println(prefix + this.xplainStrategy);
        return super.toString(prefix);
    }

    @Impure
    public void setMinimizationStrategy(MinimizationStrategy strategy) {
        this.xplainStrategy = strategy;
    }

}

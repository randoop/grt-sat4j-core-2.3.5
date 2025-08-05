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
package org.sat4j.minisat.constraints.cnf;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.sat4j.core.LiteralsUtils;
import org.sat4j.minisat.core.Constr;
import org.sat4j.minisat.core.ILits;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.UnitPropagationListener;

/**
 * 
 * @author daniel
 * @since 2.1
 */
public class UnitClause implements Constr {

    protected final int literal;
    protected double activity;

    @SideEffectFree
    public UnitClause(int value) {
        this.literal = value;
    }

    @Impure
    public void assertConstraint(UnitPropagationListener s) {
        s.enqueue(this.literal, this);
    }

    @Impure
    public void assertConstraintIfNeeded(UnitPropagationListener s) {
        assertConstraint(s);
    }

    @Impure
    public void calcReason(int p, IVecInt outReason) {
        if (p == ILits.UNDEFINED) {
            outReason.push(LiteralsUtils.neg(this.literal));
        }
    }

    @Pure
    public double getActivity() {
        return activity;
    }

    @SideEffectFree
    public void incActivity(double claInc) {
        // silent to prevent problems with xplain trick.
    }

    @Impure
    public void setActivity(double claInc) {
        activity = claInc;
    }

    @Pure
    public boolean locked() {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void register() {
        throw new UnsupportedOperationException();
    }

    @Impure
    public void remove(UnitPropagationListener upl) {
        upl.unset(this.literal);
    }

    @SideEffectFree
    public void rescaleBy(double d) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void setLearnt() {
        throw new UnsupportedOperationException();
    }

    @Pure
    public boolean simplify() {
        return false;
    }

    @Pure
    public boolean propagate(UnitPropagationListener s, int p) {
        throw new UnsupportedOperationException();
    }

    @Pure
    public int get(int i) {
        if (i > 0) {
            throw new IllegalArgumentException();
        }
        return this.literal;
    }

    @Pure
    public boolean learnt() {
        return false;
    }

    @Pure
    public int size() {
        return 1;
    }

    @SideEffectFree
    public void forwardActivity(double claInc) {
        // silent to prevent problems with xplain trick.
    }

    @Pure
    @Impure
    @Override
    public String toString() {
        return Lits.toString(this.literal);
    }

    @Pure
    public boolean canBePropagatedMultipleTimes() {
        return false;
    }

    @Impure
    public void calcReasonOnTheFly(int p, IVecInt trail, IVecInt outReason) {
        calcReason(p, outReason);
    }
}

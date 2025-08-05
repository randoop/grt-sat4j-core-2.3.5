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

import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Deterministic;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IConstr;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.ISolverService;
import org.sat4j.specs.IVec;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.SearchListener;
import org.sat4j.specs.TimeoutException;
import org.sat4j.specs.UnitClauseProvider;

public abstract class AbstractOutputSolver implements ISolver {

    protected int nbvars;

    protected int nbclauses;

    protected boolean fixedNbClauses = false;

    protected boolean firstConstr = true;

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @Pure
    public boolean removeConstr(IConstr c) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void addAllClauses(IVec<IVecInt> clauses)
            throws ContradictionException {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void setTimeout(int t) {
        // TODO Auto-generated method stub

    }

    @SideEffectFree
    public void setTimeoutMs(long t) {
        // TODO Auto-generated method stub
    }

    @Pure
    public int getTimeout() {
        return 0;
    }

    /**
     * @since 2.1
     */
    @Pure
    public long getTimeoutMs() {
        return 0L;
    }

    @SideEffectFree
    public void expireTimeout() {
        // TODO Auto-generated method stub

    }

    @Pure
    @Deterministic
    public boolean isSatisfiable(IVecInt assumps, boolean global)
            throws TimeoutException {
        throw new TimeoutException("There is no real solver behind!");
    }

    @Pure
    @Deterministic
    public boolean isSatisfiable(boolean global) throws TimeoutException {
        throw new TimeoutException("There is no real solver behind!");
    }

    @SideEffectFree
    public void printInfos(PrintWriter output, String prefix) {
    }

    @SideEffectFree
    public void setTimeoutOnConflicts(int count) {

    }

    @Pure
    public boolean isDBSimplificationAllowed() {
        return false;
    }

    @SideEffectFree
    public void setDBSimplificationAllowed(boolean status) {

    }

    @SideEffectFree
    public void printStat(PrintStream output, String prefix) {
        // TODO Auto-generated method stub
    }

    @SideEffectFree
    public void printStat(PrintWriter output, String prefix) {
        // TODO Auto-generated method stub

    }

    @Pure
    public Map<String, Number> getStat() {
        // TODO Auto-generated method stub
        return null;
    }

    @SideEffectFree
    public void clearLearntClauses() {
        // TODO Auto-generated method stub

    }

    @Pure
    public int[] model() {
        throw new UnsupportedOperationException();
    }

    @Pure
    public boolean model(int var) {
        throw new UnsupportedOperationException();
    }

    @Pure
    @Deterministic
    public boolean isSatisfiable() throws TimeoutException {
        throw new TimeoutException("There is no real solver behind!");
    }

    @Pure
    @Deterministic
    public boolean isSatisfiable(IVecInt assumps) throws TimeoutException {
        throw new TimeoutException("There is no real solver behind!");
    }

    @Pure
    public int[] findModel() throws TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Pure
    public int[] findModel(IVecInt assumps) throws TimeoutException {
        throw new UnsupportedOperationException();
    }

    /**
     * @since 2.1
     */
    @Pure
    public boolean removeSubsumedConstr(IConstr c) {
        return false;
    }

    /**
     * @since 2.1
     */
    @Pure
    public IConstr addBlockingClause(IVecInt literals)
            throws ContradictionException {
        throw new UnsupportedOperationException();
    }

    /**
     * @since 2.2
     */
    @Pure
    public <S extends ISolverService> SearchListener<S> getSearchListener() {
        throw new UnsupportedOperationException();
    }

    /**
     * @since 2.1
     */
    @SideEffectFree
    public <S extends ISolverService> void setSearchListener(
            SearchListener<S> sl) {
    }

    /**
     * @since 2.2
     */
    @Pure
    public boolean isVerbose() {
        return true;
    }

    /**
     * @since 2.2
     */
    @SideEffectFree
    public void setVerbose(boolean value) {
        // do nothing
    }

    /**
     * @since 2.2
     */
    @SideEffectFree
    public void setLogPrefix(String prefix) {
        // do nothing

    }

    /**
     * @since 2.2
     */
    @Pure
    public String getLogPrefix() {
        return "";
    }

    /**
     * @since 2.2
     */
    @Pure
    public IVecInt unsatExplanation() {
        throw new UnsupportedOperationException();
    }

    @Pure
    public int[] primeImplicant() {
        throw new UnsupportedOperationException();
    }

    @Pure
    public int nConstraints() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Impure
    public int newVar(int howmany) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Pure
    public int nVars() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Pure
    public boolean isSolverKeptHot() {
        return false;
    }

    @SideEffectFree
    public void setKeepSolverHot(boolean value) {
    }

    @Pure
    public ISolver getSolvingEngine() {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void setUnitClauseProvider(UnitClauseProvider upl) {
        throw new UnsupportedOperationException();
    }
}

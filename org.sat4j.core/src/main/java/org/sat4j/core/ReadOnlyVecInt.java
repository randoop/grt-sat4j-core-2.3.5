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
package org.sat4j.core;

import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Impure;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.IteratorInt;

/**
 * Utility class to allow Read Only access only to an IVecInt.
 * 
 * @author daniel
 * 
 */
public final class ReadOnlyVecInt implements IVecInt {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private final IVecInt vec;

    @SideEffectFree
    public ReadOnlyVecInt(IVecInt vec) {
        this.vec = vec;
    }

    @SideEffectFree
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Impure
    public boolean contains(int e) {
        return this.vec.contains(e);
    }

    @Impure
    public int containsAt(int e) {
        return this.vec.containsAt(e);
    }

    @Impure
    public int containsAt(int e, int from) {
        return this.vec.containsAt(e, from);
    }

    @Impure
    public void copyTo(IVecInt copy) {
        this.vec.copyTo(copy);
    }

    @Impure
    public void copyTo(int[] is) {
        this.vec.copyTo(is);
    }

    @Pure
    public int delete(int i) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void ensure(int nsize) {
        throw new UnsupportedOperationException();
    }

    @Impure
    public int get(int i) {
        return this.vec.get(i);
    }

    @SideEffectFree
    public void growTo(int newsize, int pad) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void insertFirst(int elem) {
        throw new UnsupportedOperationException();
    }

    @Impure
    public boolean isEmpty() {
        return this.vec.isEmpty();
    }

    @Impure
    public IteratorInt iterator() {
        return this.vec.iterator();
    }

    @Impure
    public int last() {
        return this.vec.last();
    }

    @SideEffectFree
    public void moveTo(IVecInt dest) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void moveTo(int[] dest) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void moveTo(int dest, int source) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void moveTo2(IVecInt dest) {
        throw new UnsupportedOperationException();
    }

    @Pure
    public IVecInt pop() {
        throw new UnsupportedOperationException();
    }

    @Pure
    public IVecInt push(int elem) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void remove(int elem) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void set(int i, int o) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void shrink(int nofelems) {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void shrinkTo(int newsize) {
        throw new UnsupportedOperationException();
    }

    @Impure
    public int size() {
        return this.vec.size();
    }

    @SideEffectFree
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @SideEffectFree
    public void sortUnique() {
        throw new UnsupportedOperationException();
    }

    @Impure
    public int unsafeGet(int eleem) {
        return this.vec.unsafeGet(eleem);
    }

    @SideEffectFree
    public void unsafePush(int elem) {
        throw new UnsupportedOperationException();
    }

    /**
     * @since 2.1
     */
    @Pure
    public int[] toArray() {
        throw new UnsupportedOperationException();
    }

    /**
     * @since 2.2
     */
    @Impure
    public int indexOf(int e) {
        return this.vec.indexOf(e);
    }

    @SideEffectFree
    @Override
    public String toString() {
        return this.vec.toString();
    }

    @SideEffectFree
    public void moveTo(int sourceStartingIndex, int[] dest) {
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @author sroussel
     * @since 2.3.1
     */
    @Pure
    public VecInt[] subset(int cardinal) {
        return null;
    }

    @Pure
    @Override
    public int hashCode() {
        return this.vec.hashCode();
    }

    @Pure
    @Override
    public boolean equals(Object obj) {
        return this.vec.equals(obj);
    }

}

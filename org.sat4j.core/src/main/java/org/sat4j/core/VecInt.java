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

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.sat4j.specs.IVecInt;
import org.sat4j.specs.IteratorInt;

/*
 * Created on 9 oct. 2003
 */

/**
 * A vector specific for primitive integers, widely used in the solver. Note
 * that if the vector has a sort method, the operations on the vector DO NOT
 * preserve sorting.
 * 
 * @author leberre
 */
public final class VecInt implements IVecInt {
    // MiniSat -- Copyright (c) 2003-2005, Niklas Een, Niklas Sorensson
    //
    // Permission is hereby granted, free of charge, to any person obtaining a
    // copy of this software and associated documentation files (the
    // "Software"), to deal in the Software without restriction, including
    // without limitation the rights to use, copy, modify, merge, publish,
    // distribute, sublicense, and/or sell copies of the Software, and to
    // permit persons to whom the Software is furnished to do so, subject to
    // the following conditions:
    //
    // The above copyright notice and this permission notice shall be included
    // in all copies or substantial portions of the Software.
    //
    // THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
    // OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    // MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
    // NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
    // LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
    // OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
    // WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

    private static final long serialVersionUID = 1L;

    public static final IVecInt EMPTY = new IVecInt() {

        /**
		 * 
		 */
        private static final long serialVersionUID = 1L;

        @Pure
        public int size() {
            return 0;
        }

        @SideEffectFree
        public void shrink(int nofelems) {
        }

        @SideEffectFree
        public void shrinkTo(int newsize) {
        }

        @Pure
        public IVecInt pop() {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void growTo(int newsize, int pad) {
        }

        @SideEffectFree
        public void ensure(int nsize) {
        }

        @Pure
        public IVecInt push(int elem) {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void unsafePush(int elem) {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void clear() {
        }

        @Pure
        public int last() {
            throw new UnsupportedOperationException();
        }

        @Pure
        public int get(int i) {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void set(int i, int o) {
            throw new UnsupportedOperationException();
        }

        @Pure
        public boolean contains(int e) {
            return false;
        }

        @SideEffectFree
        public void copyTo(IVecInt copy) {
        }

        @SideEffectFree
        public void copyTo(int[] is) {
        }

        @SideEffectFree
        public void moveTo(IVecInt dest) {
        }

        @SideEffectFree
        public void moveTo2(IVecInt dest) {
        }

        @SideEffectFree
        public void moveTo(int[] dest) {
        }

        @SideEffectFree
        public void insertFirst(int elem) {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void remove(int elem) {
            throw new UnsupportedOperationException();
        }

        @Pure
        public int delete(int i) {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void sort() {
        }

        @SideEffectFree
        public void sortUnique() {
        }

        @Pure
        public int unsafeGet(int eleem) {
            throw new UnsupportedOperationException();
        }

        @Pure
        public int containsAt(int e) {
            throw new UnsupportedOperationException();
        }

        @Pure
        public int containsAt(int e, int from) {
            throw new UnsupportedOperationException();
        }

        @SideEffectFree
        public void moveTo(int dest, int source) {
            throw new UnsupportedOperationException();
        }

        @Pure
        public boolean isEmpty() {
            return true;
        }

        @Impure
        public IteratorInt iterator() {
            return new IteratorInt() {

                @Pure
                public boolean hasNext() {
                    return false;
                }

                @Pure
                public int next() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Pure
        public int[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Pure
        public int indexOf(int e) {
            return -1;
        }

        @Pure
        @Override
        public String toString() {
            return "[]";
        }

        @SideEffectFree
        public void moveTo(int sourceStartingIndex, int[] dest) {
            throw new UnsupportedOperationException();
        }

        @Pure
        public IVecInt[] subset(int cardinal) {
            return new IVecInt[0];
        };

        @Impure
        @Override
        public boolean equals(Object o) {
            if (o instanceof IVecInt) {
                return ((IVecInt) o).isEmpty();
            }
            return false;
        }

        @Pure
        @Override
        public int hashCode() {
            return 0;
        }
    };

    public VecInt() {
        this(5);
    }

    @SideEffectFree
    public VecInt(int size) {
        this.myarray = new int[size];
    }

    /**
     * Adapter method to translate an array of int into an IVecInt.
     * 
     * The array is used inside the VecInt, so the elements may be modified
     * outside the VecInt. But it should not take much memory.The size of the
     * created VecInt is the length of the array.
     * 
     * @param lits
     *            a filled array of int.
     */
    @SideEffectFree
    public VecInt(int[] lits) { // NOPMD
        this.myarray = lits;
        this.nbelem = lits.length;
    }

    /**
     * Build a vector of a given initial size filled with an integer.
     * 
     * @param size
     *            the initial size of the vector
     * @param pad
     *            the integer to fill the vector with
     */
    @Impure
    public VecInt(int size, int pad) {
        this.myarray = new int[size];
        for (int i = 0; i < size; i++) {
            this.myarray[i] = pad;
        }
        this.nbelem = size;
    }

    @Pure
    public int size() {
        return this.nbelem;
    }

    /**
     * Remove the latest nofelems elements from the vector
     * 
     * @param nofelems
     */
    @Impure
    public void shrink(int nofelems) {
        // assert nofelems >= 0;
        // assert nofelems <= size();
        this.nbelem -= nofelems;
    }

    @Impure
    public void shrinkTo(int newsize) {
        // assert newsize >= 0;
        // assert newsize < nbelem;
        this.nbelem = newsize;
    }

    /**
     * depile le dernier element du vecteur. Si le vecteur est vide, ne fait
     * rien.
     */
    @Impure
    public IVecInt pop() {
        // assert size() != 0;
        --this.nbelem;
        return this;
    }

    @Impure
    public void growTo(int newsize, final int pad) {
        // assert newsize > size();
        ensure(newsize);
        while (--newsize >= 0) {
            this.myarray[this.nbelem++] = pad;
        }
    }

    @Impure
    public void ensure(int nsize) {
        if (nsize >= this.myarray.length) {
            int[] narray = new int[Math.max(nsize, this.nbelem * 2)];
            System.arraycopy(this.myarray, 0, narray, 0, this.nbelem);
            this.myarray = narray;
        }
    }

    @Impure
    public IVecInt push(int elem) {
        ensure(this.nbelem + 1);
        this.myarray[this.nbelem++] = elem;
        return this;
    }

    @Impure
    public void unsafePush(int elem) {
        this.myarray[this.nbelem++] = elem;
    }

    @Impure
    public void clear() {
        this.nbelem = 0;
    }

    @Pure
    public int last() {
        // assert nbelem > 0;
        return this.myarray[this.nbelem - 1];
    }

    @Pure
    public int get(int i) {
        // assert i >= 0 && i < nbelem;
        return this.myarray[i];
    }

    @Pure
    public int unsafeGet(int i) {
        return this.myarray[i];
    }

    @Impure
    public void set(int i, int o) {
        assert i >= 0 && i < this.nbelem;
        this.myarray[i] = o;
    }

    @Pure
    public boolean contains(int e) {
        final int[] workArray = this.myarray; // dvh, faster access
        for (int i = 0; i < this.nbelem; i++) {
            if (workArray[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * @since 2.2
     */
    @Pure
    public int indexOf(int e) {
        final int[] workArray = this.myarray; // dvh, faster access
        for (int i = 0; i < this.nbelem; i++) {
            if (workArray[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Pure
    @Impure
    public int containsAt(int e) {
        return containsAt(e, -1);
    }

    @Pure
    public int containsAt(int e, int from) {
        final int[] workArray = this.myarray; // dvh, faster access
        for (int i = from + 1; i < this.nbelem; i++) {
            if (workArray[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Copy the content of this vector into another one. Non constant time
     * operation.
     * 
     * @param copy
     */
    @Impure
    public void copyTo(IVecInt copy) {
        VecInt ncopy = (VecInt) copy;
        int nsize = this.nbelem + ncopy.nbelem;
        ncopy.ensure(nsize);
        System.arraycopy(this.myarray, 0, ncopy.myarray, ncopy.nbelem,
                this.nbelem);
        ncopy.nbelem = nsize;
    }

    /**
     * Copy the content of this vector into an array of integer. Non constant
     * time operation.
     * 
     * @param is
     */
    @SideEffectFree
    public void copyTo(int[] is) {
        // assert is.length >= nbelem;
        System.arraycopy(this.myarray, 0, is, 0, this.nbelem);
    }

    @Impure
    public void moveTo(IVecInt dest) {
        copyTo(dest);
        this.nbelem = 0;
    }

    @Impure
    public void moveTo2(IVecInt dest) {
        VecInt ndest = (VecInt) dest;
        int tmp[] = ndest.myarray;
        ndest.myarray = this.myarray;
        ndest.nbelem = this.nbelem;
        this.myarray = tmp;
        this.nbelem = 0;
    }

    @Impure
    public void moveTo(int dest, int source) {
        this.myarray[dest] = this.myarray[source];
    }

    @Impure
    public void moveTo(int[] dest) {
        System.arraycopy(this.myarray, 0, dest, 0, this.nbelem);
        this.nbelem = 0;
    }

    @Impure
    public void moveTo(int sourceStartingIndex, int[] dest) {
        System.arraycopy(this.myarray, sourceStartingIndex, dest, 0,
                this.nbelem - sourceStartingIndex);
        this.nbelem = 0;
    }

    /**
     * Insert an element at the very begining of the vector. The former first
     * element is appended to the end of the vector in order to have a constant
     * time operation.
     * 
     * @param elem
     *            the element to put first in the vector.
     */
    @Impure
    public void insertFirst(final int elem) {
        if (this.nbelem > 0) {
            push(this.myarray[0]);
            this.myarray[0] = elem;
            return;
        }
        push(elem);
    }

    /**
     * Enleve un element qui se trouve dans le vecteur!!!
     * 
     * @param elem
     *            un element du vecteur
     */
    @Impure
    public void remove(int elem) {
        // assert size() > 0;
        int j = 0;
        for (; this.myarray[j] != elem; j++) {
            assert j < size();
        }
        System.arraycopy(this.myarray, j + 1, this.myarray, j, size() - j - 1);
        pop();
    }

    /**
     * Delete the ith element of the vector. The latest element of the vector
     * replaces the removed element at the ith indexer.
     * 
     * @param i
     *            the indexer of the element in the vector
     * @return the former ith element of the vector that is now removed from the
     *         vector
     */
    @Impure
    public int delete(int i) {
        // assert i >= 0 && i < nbelem;
        int ith = this.myarray[i];
        this.myarray[i] = this.myarray[--this.nbelem];
        return ith;
    }

    private int nbelem;

    private int[] myarray;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.int#toString()
     */
    @Impure
    @Override
    public String toString() {
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < this.nbelem - 1; i++) {
            stb.append(this.myarray[i]);
            stb.append(","); //$NON-NLS-1$
        }
        if (this.nbelem > 0) {
            stb.append(this.myarray[this.nbelem - 1]);
        }
        return stb.toString();
    }

    @Impure
    void selectionSort(int from, int to) {
        int i, j, besti;
        int tmp;

        for (i = from; i < to - 1; i++) {
            besti = i;
            for (j = i + 1; j < to; j++) {
                if (this.myarray[j] < this.myarray[besti]) {
                    besti = j;
                }
            }
            tmp = this.myarray[i];
            this.myarray[i] = this.myarray[besti];
            this.myarray[besti] = tmp;
        }
    }

    @Impure
    void sort(int from, int to) {
        int width = to - from;
        if (width <= 15) {
            selectionSort(from, to);
        } else {
            final int[] locarray = this.myarray;
            int pivot = locarray[width / 2 + from];
            int tmp;
            int i = from - 1;
            int j = to;

            for (;;) {
                do {
                    i++;
                } while (locarray[i] < pivot);
                do {
                    j--;
                } while (pivot < locarray[j]);

                if (i >= j) {
                    break;
                }

                tmp = locarray[i];
                locarray[i] = locarray[j];
                locarray[j] = tmp;
            }

            sort(from, i);
            sort(i, to);
        }
    }

    /**
     * sort the vector using a custom quicksort.
     */
    @Impure
    public void sort() {
        sort(0, this.nbelem);
    }

    @Impure
    public void sortUnique() {
        int i, j;
        int last;
        if (this.nbelem == 0) {
            return;
        }

        sort(0, this.nbelem);
        i = 1;
        int[] locarray = this.myarray;
        last = locarray[0];
        for (j = 1; j < this.nbelem; j++) {
            if (last < locarray[j]) {
                last = locarray[i] = locarray[j];
                i++;
            }
        }

        this.nbelem = i;
    }

    /**
     * Two vectors are equals iff they have the very same elements in the order.
     * 
     * @param obj
     *            an object
     * @return true iff obj is a VecInt and has the same elements as this vector
     *         at each index.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Impure
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IVecInt) {
            IVecInt v = (IVecInt) obj;
            if (v.size() != this.nbelem) {
                return false;
            }
            for (int i = 0; i < this.nbelem; i++) {
                if (v.get(i) != this.myarray[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Pure
    @Override
    public int hashCode() {
        long sum = 0;
        for (int i = 0; i < this.nbelem; i++) {
            sum += this.myarray[i];
        }
        return (int) sum / this.nbelem;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.sat4j.specs.IVecInt2#pushAll(org.sat4j.specs.IVecInt2)
     */
    @Impure
    public void pushAll(IVecInt vec) {
        VecInt nvec = (VecInt) vec;
        int nsize = this.nbelem + nvec.nbelem;
        ensure(nsize);
        System.arraycopy(nvec.myarray, 0, this.myarray, this.nbelem,
                nvec.nbelem);
        this.nbelem = nsize;
    }

    /**
     * to detect that the vector is a subset of another one. Note that the
     * method assumes that the two vectors are sorted!
     * 
     * @param vec
     *            a vector
     * @return true iff the current vector is a subset of vec
     */
    @Pure
    public boolean isSubsetOf(VecInt vec) {
        int i = 0;
        int j = 0;
        while (i < this.nbelem && j < vec.nbelem) {
            while (j < vec.nbelem && vec.myarray[j] < this.myarray[i]) {
                j++;
            }
            if (j == vec.nbelem || this.myarray[i] != vec.myarray[j]) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Impure
    public IteratorInt iterator() {
        return new IteratorInt() {
            private int i = 0;

            @Pure
            public boolean hasNext() {
                return this.i < VecInt.this.nbelem;
            }

            @Impure
            public int next() {
                if (this.i == VecInt.this.nbelem) {
                    throw new NoSuchElementException();
                }
                return VecInt.this.myarray[this.i++];
            }
        };
    }

    @Pure
    public boolean isEmpty() {
        return this.nbelem == 0;
    }

    /**
     * @since 2.1
     */
    @Pure
    public int[] toArray() {
        return this.myarray;
    }

    /**
     * @since 2.3.1
     * @author sroussel
     */
    @Impure
    public IVecInt[] subset(int cardinal) {
        List<IVecInt> liste = new ArrayList<IVecInt>();

        IVecInt[] result;

        if (cardinal == 1) {
            result = new VecInt[this.size()];
            for (int i = 0; i < this.size(); i++) {
                result[i] = new VecInt(new int[] { this.get(i) });
            }
            return result;
        }

        if (this.size() == 0) {
            result = new VecInt[0];
            return result;
        }

        VecInt subVec = new VecInt();
        VecInt newVec;
        this.copyTo(subVec);
        subVec.remove(this.get(0));

        for (IVecInt vecWithFirst : subVec.subset(cardinal - 1)) {
            newVec = new VecInt();
            vecWithFirst.copyTo(newVec);
            newVec.insertFirst(this.get(0));
            liste.add(newVec);
        }

        for (IVecInt vecWithoutFirst : subVec.subset(cardinal)) {
            liste.add(vecWithoutFirst);
        }

        result = new VecInt[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            result[i] = liste.get(i);
        }
        return result;
    }
}

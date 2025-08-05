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
package org.sat4j.specs;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import java.io.Serializable;

/**
 * An abstraction for the vector of int used on the library.
 * 
 * @author leberre
 */
public interface IVecInt extends Serializable {

    @Impure
    int size();

    /**
     * Remove the latest nofelems elements from the vector
     * 
     * @param nofelems
     */
    @Impure
    void shrink(int nofelems);

    @Impure
    void shrinkTo(int newsize);

    /**
     * depile le dernier element du vecteur. Si le vecteur est vide, ne fait
     * rien.
     */
    @Impure
    IVecInt pop();

    @Impure
    void growTo(int newsize, final int pad);

    @Impure
    void ensure(int nsize);

    @Impure
    IVecInt push(int elem);

    /**
     * Push the element in the Vector without verifying if there is room for it.
     * USE WITH CAUTION!
     * 
     * @param elem
     */
    @Impure
    void unsafePush(int elem);

    @Impure
    int unsafeGet(int eleem);

    @Impure
    void clear();

    @Impure
    int last();

    @Impure
    int get(int i);

    @Impure
    void set(int i, int o);

    @Impure
    boolean contains(int e);

    /**
     * @since 2.2
     * @param e
     * @return
     */
    @Impure
    int indexOf(int e);

    /**
     * returns the index of the first occurrence of e, else -1.
     * 
     * @param e
     *            an integer
     * @return the index i such that get(i)==e, else -1.
     */
    @Impure
    int containsAt(int e);

    /**
     * returns the index of the first occurence of e occurring after from
     * (excluded), else -1.
     * 
     * @param e
     *            an integer
     * @param from
     *            the index to start from (excluded).
     * @return the index i such that i>from and get(i)==e, else -1
     */
    @Impure
    int containsAt(int e, int from);

    /**
     * C'est operations devraient se faire en temps constant. Ce n'est pas le
     * cas ici.
     * 
     * @param copy
     */
    @Impure
    void copyTo(IVecInt copy);

    /**
     * @param is
     */
    @Impure
    void copyTo(int[] is);

    /*
     * Copie un vecteur dans un autre (en vidant le premier), en temps constant.
     */
    @Impure
    void moveTo(IVecInt dest);

    @Impure
    void moveTo(int sourceStartingIndex, int[] dest);

    @Impure
    void moveTo2(IVecInt dest);

    @Impure
    void moveTo(int[] dest);

    /**
     * Move elements inside the vector. The content of the method is equivalent
     * to: <code>vec[dest] = vec[source]</code>
     * 
     * @param dest
     *            the index of the destination
     * @param source
     *            the index of the source
     */
    @Impure
    void moveTo(int dest, int source);

    /**
     * Insert an element at the very begining of the vector. The former first
     * element is appended to the end of the vector in order to have a constant
     * time operation.
     * 
     * @param elem
     *            the element to put first in the vector.
     */
    @Impure
    void insertFirst(final int elem);

    /**
     * Enleve un element qui se trouve dans le vecteur!!!
     * 
     * @param elem
     *            un element du vecteur
     */
    @Impure
    void remove(int elem);

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
    int delete(int i);

    @Impure
    void sort();

    @Impure
    void sortUnique();

    /**
     * To know if a vector is empty
     * 
     * @return true iff the vector is empty.
     * @since 1.6
     */
    @Impure
    boolean isEmpty();

    @Impure
    IteratorInt iterator();

    /**
     * Allow to access the internal representation of the vector as an array.
     * Note that only the content of index 0 to size() should be taken into
     * account. USE WITH CAUTION
     * 
     * @return the internal representation of the Vector as an array.
     * @since 2.1
     */
    @Pure
    int[] toArray();

    /**
     * Compute all subsets of cardinal k of the vector.
     * 
     * @param k
     *            a cardinal (k<= vec.size())
     * @return an array of IVectInt representing each a k-subset of this vector.
     * @author sroussel
     * @since 2.3.1
     */
    @Impure
    IVecInt[] subset(int k);
}

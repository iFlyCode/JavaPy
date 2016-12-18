/* Copyright (c) 2016 Kevin Wong and Nicholas Colaprete
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */
package com.git.iflycode.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author ifly6
 * @param <E>
 *
 */
public class JPListMaker<E> {

	List<E> internalList;

	public JPListMaker() {
		this.internalList = new ArrayList<E>();
	}

	public int size() {
		return internalList.size();
	}

	public boolean isEmpty() {
		if (size() == 0) { return true; }
		return false;
	}

	/**
	 * Implements the add method used in {@link java.util.List#add List#add} onto the internal list.
	 *
	 * @param e is the object to be added
	 * @return the list, operated upon by its relevant <code>add</code> method
	 */
	public JPListMaker<E> add(E e) {
		internalList.add(e);
		return this;
	}

	public JPListMaker<E> addAll(Collection<E> e) {
		internalList.addAll(e);
		return this;
	}

	/**
	 * Implements the remove method used in {@link java.util.List#remove List#remove} onto the internal list.
	 *
	 * @param e is the object to be removed
	 * @return the list, operated upon by its relevant <code>remove</code> method
	 */
	public JPListMaker<E> remove(E e) {
		internalList.remove(e);
		return this;
	}

	public Iterator<E> iterator() {
		return internalList.iterator();
	}

	/**
	 * Creates the list and finalises that list.
	 *
	 * @return
	 */
	public List<E> create() {
		return internalList;
	}

}

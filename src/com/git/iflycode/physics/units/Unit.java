/* Copyright (c) 2015 Kevin Wong and Nicholas Colaprete
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

package com.git.iflycode.physics.units;

/**
 * This is the base class for all physical units. It simply gives you a way of storing, getting, and setting the value
 * of the unit.
 *
 * All units should initialise with a value of 0 (if given no initialisation) and should have a unit String attached.
 */
public class Unit implements UnitBean {

	/**
	 * Contains the value of the <code>Unit</code>
	 */
	double value;

	/**
	 * Contains the name of the <code>Unit</code>, for example, 'N' for Newtons or 'kg' for kilogrammes.
	 */
	public final String unit = "";

	/**
	 * Constructs the <code>Unit</code> with a default initial value of 0.
	 */
	public Unit() {
		value = 0;
	}

	/**
	 * Constructs the <code>Unit</code> with a set initial value.
	 *
	 * @param initValue is the value to which the <code>Unit</code> will be set upon creation
	 */
	public Unit(double initValue) {
		value = initValue;
	}

	/**
	 * Constructs the <code>Unit</code> with a set initial value.
	 *
	 * @param initValue is the value to which the <code>Unit</code> will be set upon creation
	 */
	public Unit(int initValue) {
		this((double) initValue);
	}

	/**
	 * Gets the value of the <code>Unit</code>.
	 *
	 * @return the value of the <code>Unit</code>
	 */
	@Override public double getValue() {
		return value;
	}

	/**
	 * Sets the value of the <code>Unit</code>.
	 *
	 * @param setValue is the new value to which the <code>Unit</code> should be set
	 */
	@Override public void setValue(double setValue) {
		value = setValue;
	}

	/**
	 * Returns a <code>String</code> representation of the <code>Unit</code>, accompanied with the unit name.
	 */
	@Override public String toString() {
		return (Double.toString(value) + " " + unit);
	}
}

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

package com.git.iflycode.physics;

import com.git.iflycode.physics.units.Kilogram;
import com.git.iflycode.physics.units.Metre;
import com.git.iflycode.physics.units.Newton;

/**
 * Methods relating to the physics concept of Gravitation should go here, sorted by which parameter in which they apply,
 * like Newtonian, etc.
 */
public class Gravitation {

	public static final double gravitationalConstant = 6.67384E-11;
	public static final double seaLevelGravity = 9.8196;

	/**
	 * Calculates the force of an object falling in standard Earth gravity.
	 *
	 * @param mass of the object in question.
	 * @return the force in Newtons exerted by the object in Earth sea-level gravity
	 */
	public static Newton earth(Kilogram mass) {
		return new Newton(mass.getValue() * 9.8196);
	}

	/**
	 * Calculates the force exerted by an object by another with the standard gravitational constant.
	 *
	 * @param mass1 of first object
	 * @param mass2 of second object
	 * @param distance between the two masses
	 * @return the force in Newtons exerted by the object in Earth sea-level gravity
	 */
	public static Newton newtonian(Kilogram mass1, Kilogram mass2, Metre distance) {
		return newtonian(mass1, mass2, distance, gravitationalConstant);
	}

	/**
	 * Calculates the force exerted by an object by another with a custom gravitational constant.
	 *
	 * @param mass1 of first object
	 * @param mass2 of second object
	 * @param distance - distance between the two masses
	 * @param gravConstant - the gravitational constant
	 * @return
	 */
	public static Newton newtonian(Kilogram mass1, Kilogram mass2, Metre distance, double gravConstant) {
		double newtons = gravConstant * ((mass1.getValue() * mass2.getValue()) / (Math.pow(distance.getValue(), 2)));
		return new Newton(newtons);
	}
}

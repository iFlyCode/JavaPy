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

import com.git.iflycode.physics.units.Unit;
import com.git.iflycode.util.exceptions.UnitMismatchException;

public class Units {

	public static Unit add(Unit a, Unit b) throws UnitMismatchException {
		if (!a.unit.equals(b.unit)) {
			throw new UnitMismatchException();
		} else {
			return new Unit(a.getValue() + b.getValue());
		}
	}

	public static Unit subtract(Unit a, Unit b) throws UnitMismatchException {
		if (!a.unit.equals(b.unit)) {
			throw new UnitMismatchException();
		} else {
			return new Unit(a.getValue() - b.getValue());
		}
	}

	/* TODO Find some way to actually doing analysis of the units themselves. I want to multiply Newtons and Metres and
	 * have Joules come out. Unfortunately, how the hell would I do that? */
	public static Unit multiply(Unit a, Unit b) {
		return new Unit(a.getValue() * b.getValue());
	}

	public static Unit divide(Unit a, Unit b) {
		return new Unit(a.getValue() / b.getValue());
	}
}
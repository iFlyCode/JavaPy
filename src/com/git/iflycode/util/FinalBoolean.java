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

package com.git.iflycode.util;

public class FinalBoolean {
	
	boolean setting = false;
	boolean finalised = false;
	
	/** Constructs the <code>FinalBoolean</code> object with a predetermined setting. Also automatically finalises.
	 * @param finalSetting should be self-evident */
	public FinalBoolean(boolean finalSetting) {
		setting = finalSetting;
		finalise();
	}
	
	/** This method sets the boolean if it has not already been set.
	 * @param newSetting - sets the boolean and finalises it */
	public void set(boolean newSetting) {
		if (!finalised) {
			setting = newSetting;
			finalise();
		}
	}
	
	/** If it has not yet been finalised, this method finalises the setting. It is called by the internal components of
	 * the class. */
	private void finalise() {
		this.finalised = true;
	}

	/** Checks whether the <code>FinalBoolean</code> is finalised or not.
	 * @return whether it is finalised */
	public boolean isFinalised() {
		return finalised;
	}
	
	/** Determines the value of the final boolean.
	 * @return the value of the encapsulated boolean */
	public boolean getValue() {
		return this.setting;
	}
	
}

/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.greenfield.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(iterations = 2)
@Warmup(iterations = 1)
@Fork(value = 1, warmups = 0)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
public class MyBenchmark {

	@Benchmark
	public void testParallelArraySort_10(ParallelState state) {
		state.setSize(10);
	}
	
	@Benchmark
	public void testParallelArraySort_20(ParallelState state) {
		state.setSize(20);
	}

	@Benchmark
	public void testSequentialArraySort_10(ParallelState state) {
		state.setSize(10);
	}
	
	@Benchmark
	public void testSequentialArraySort_20(ParallelState state) {
		state.setSize(20);
	}
	
	@State(Scope.Thread)
	public static class SequentialState extends BaseState {

		@Setup(Level.Invocation)
		public void init() {
			array = generateArray();
		}

		@TearDown(Level.Invocation)
		public void destroy() {
			array = null;
		}

		public void run() {
			MathHelper.sequenatialSort(array);
		}
	}

	@State(Scope.Thread)
	public static class ParallelState extends BaseState {

		@Setup(Level.Invocation)
		public void init() {
			array = generateArray();
		}

		@TearDown(Level.Invocation)
		public void destroy() {
			array = null;
		}

		public void run() {
			MathHelper.parallelSort(array);
		}
	}

}

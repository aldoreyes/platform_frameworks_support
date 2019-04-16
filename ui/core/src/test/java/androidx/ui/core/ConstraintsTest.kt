/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ConstraintsTest {

    @Test
    fun constructor() {
        val defaultConstraints = Constraints()
        defaultConstraints.assertEquals(IntPx.Zero, IntPx.Infinity, IntPx.Zero, IntPx.Infinity)

        val constraints = Constraints(0.ipx, 1.ipx, 2.ipx, 3.ipx)
        constraints.assertEquals(0.ipx, 1.ipx, 2.ipx, 3.ipx)

        val tightConstraintsForWidth = Constraints.tightConstraintsForWidth(5.ipx)
        tightConstraintsForWidth.assertEquals(5.ipx, 5.ipx, IntPx.Zero, IntPx.Infinity)

        val tightConstraintsForHeight = Constraints.tightConstraintsForHeight(5.ipx)
        tightConstraintsForHeight.assertEquals(IntPx.Zero, IntPx.Infinity, 5.ipx, 5.ipx)

        val tightConstraints = Constraints.tightConstraints(5.ipx, 7.ipx)
        tightConstraints.assertEquals(5.ipx, 5.ipx, 7.ipx, 7.ipx)
    }

    @Test
    fun hasBoundedDimensions() {
        val unbounded = Constraints(3.ipx, IntPx.Infinity, 3.ipx, IntPx.Infinity)
        assertFalse(unbounded.hasBoundedWidth)
        assertFalse(unbounded.hasBoundedHeight)

        val bounded = Constraints(3.ipx, 5.ipx, 3.ipx, 5.ipx)
        assertTrue(bounded.hasBoundedWidth)
        assertTrue(bounded.hasBoundedHeight)
    }

    @Test
    fun hasTightDimensions() {
        val untight = Constraints(3.ipx, 4.ipx, 8.ipx, 9.ipx)
        assertFalse(untight.hasTightWidth)
        assertFalse(untight.hasTightHeight)
        assertFalse(untight.isTight)

        val tight = Constraints(3.ipx, 3.ipx, 5.ipx, 5.ipx)
        assertTrue(tight.hasBoundedWidth)
        assertTrue(tight.hasBoundedHeight)
        assertTrue(tight.isTight)
    }

    @Test
    fun isZero() {
        val nonZero = Constraints(1.ipx, 2.ipx, 1.ipx, 2.ipx)
        assertFalse(nonZero.isZero)

        val zero = Constraints(0.ipx, 0.ipx, 0.ipx, 0.ipx)
        assertTrue(zero.isZero)
    }

    @Test
    fun satisfiable() {
        val satisfiable = Constraints(1.ipx, 2.ipx, 1.ipx, 2.ipx)
        assertTrue(satisfiable.satisfiable)

        val nonSatisfiable1 = Constraints(2.ipx, 1.ipx, 0.ipx, 1.ipx)
        assertFalse(nonSatisfiable1.satisfiable)

        val nonSatisfiable2 = Constraints(0.ipx, 1.ipx, 2.ipx, 1.ipx)
        assertFalse(nonSatisfiable2.satisfiable)
    }

    @Test
    fun enforce() {
        val constraints = Constraints(5.ipx, 10.ipx, 5.ipx, 10.ipx)
        constraints.enforce(Constraints(4.ipx, 11.ipx, 4.ipx, 11.ipx)).assertEquals(
            5.ipx, 10.ipx, 5.ipx, 10.ipx
        )
        constraints.enforce(Constraints(7.ipx, 9.ipx, 7.ipx, 9.ipx)).assertEquals(
            7.ipx, 9.ipx, 7.ipx, 9.ipx
        )
        constraints.enforce(Constraints(2.ipx, 3.ipx, 2.ipx, 3.ipx)).assertEquals(
            3.ipx, 3.ipx, 3.ipx, 3.ipx
        )
        constraints.enforce(Constraints(10.ipx, 11.ipx, 10.ipx, 11.ipx)).assertEquals(
            10.ipx, 10.ipx, 10.ipx, 10.ipx
        )
    }

    @Test
    fun withTight() {
        val constraints = Constraints(2.ipx, 3.ipx, 2.ipx, 3.ipx)
        constraints.withTight().assertEquals(2.ipx, 3.ipx, 2.ipx, 3.ipx)
        constraints.withTight(7.ipx, 8.ipx).assertEquals(7.ipx, 7.ipx, 8.ipx, 8.ipx)
    }

    @Test
    fun constrain() {
        val constraints = Constraints(2.ipx, 5.ipx, 2.ipx, 5.ipx)
        assertEquals(IntPxSize(2.ipx, 2.ipx), constraints.constrain(IntPxSize(1.ipx, 1.ipx)))
        assertEquals(IntPxSize(3.ipx, 3.ipx), constraints.constrain(IntPxSize(3.ipx, 3.ipx)))
        assertEquals(IntPxSize(5.ipx, 5.ipx), constraints.constrain(IntPxSize(7.ipx, 7.ipx)))
    }

    private fun Constraints.assertEquals(
        minWidth: IntPx,
        maxWidth: IntPx,
        minHeight: IntPx,
        maxHeight: IntPx
    ): Boolean {
        return this.minWidth == minWidth && this.maxWidth == maxWidth &&
                this.minHeight == minHeight && this.maxHeight == maxHeight
    }
}
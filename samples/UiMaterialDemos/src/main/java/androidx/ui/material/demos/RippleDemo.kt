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

package androidx.ui.material.demos

import androidx.ui.core.CraneWrapper
import androidx.ui.core.dp
import androidx.ui.layout.Container
import androidx.ui.layout.EdgeInsets
import androidx.ui.material.MaterialTheme
import androidx.ui.material.StyledText
import androidx.ui.material.borders.BorderRadius
import androidx.ui.material.borders.BorderSide
import androidx.ui.material.borders.RoundedRectangleBorder
import androidx.ui.material.ripple.BoundedRipple
import androidx.ui.material.surface.Card
import androidx.ui.painting.Color
import com.google.r4a.Composable
import com.google.r4a.composer

@Composable
fun RippleDemo() {
    <CraneWrapper>
        <MaterialTheme>
            <Container padding=EdgeInsets(50.dp)>
                val shape = RoundedRectangleBorder(
                    side = BorderSide(Color(0x80000000.toInt())),
                    borderRadius = BorderRadius.circular(100f)
                )
                <Card shape>
                    <BoundedRipple>
                        <Container expanded=true>
                            <BoundedRipple>
                                <Container width=100.dp height=50.dp>
                                    <StyledText text="inner" style={ body1 } />
                                </Container>
                            </BoundedRipple>
                        </Container>
                    </BoundedRipple>
                </Card>
            </Container>
        </MaterialTheme>
    </CraneWrapper>
}
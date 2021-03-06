/*   
 * Copyright 2013 Karsten Patzwaldt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.muckebox.android.ui.utils;

import android.animation.IntEvaluator;
import android.widget.ListView;

public class ScrollYAnimator extends IntEvaluator {
    private ListView mView;
    private int mIndex;
    
    public ScrollYAnimator(ListView view, int index) {
        mView = view;
        mIndex = index;
    }
    
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue)
    {
        final int num = super.evaluate(fraction, startValue, endValue);
        
        mView.setSelectionFromTop(mIndex, num);
        
        return num;
    }
}

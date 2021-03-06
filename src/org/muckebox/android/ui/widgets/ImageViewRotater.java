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

package org.muckebox.android.ui.widgets;

import org.muckebox.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ImageViewRotater  {
	static public ImageView getRotatingImageView(Context context, int resource_id) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    
		ImageView iv = (ImageView) inflater.inflate(resource_id, null);

		Animation rotation = AnimationUtils.loadAnimation(context, R.anim.clockwise_refresh);
	    rotation.setRepeatCount(Animation.INFINITE);
	    iv.startAnimation(rotation);
	    
	    return iv;
	}
}

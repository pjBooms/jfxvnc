package org.jfxvnc.net.rfb.render.rect;

import org.jfxvnc.net.rfb.codec.Encoding;

/*
 * #%L
 * RFB protocol
 * %%
 * Copyright (C) 2015 comtel2000
 * %%
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
 * #L%
 */

public class ZlibImageRect extends RawImageRect {

    public ZlibImageRect(int x, int y, int width, int height, int[] pixels) {
	super(x, y, width, height, pixels);
    }

    @Override
    public Encoding getEncoding() {
	return Encoding.ZLIB;
    }

    @Override
    public String toString() {
	return "ZlibRawImageRect [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", pixels.length=" + (getPixels() != null ? getPixels().length : "null") + "]";
    }
}

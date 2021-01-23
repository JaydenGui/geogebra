package org.geogebra.web.richtext.impl;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public interface HasContentAndFormat  extends HasContent{

	void setFormatting(String key, Object val);

	<T> T getFormatting(String key, T fallback);

	void init(int width, int height);

	void stopEditing();
}

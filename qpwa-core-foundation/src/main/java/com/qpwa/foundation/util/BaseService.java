package com.qpwa.foundation.util;

import com.qpwa.foundation.util.LogEnabled;

public interface BaseService<T> extends LogEnabled {

	public void removeUnused(String paramString);

	public T get(String paramString);

	public void saveOrUpdate(T paramT);
}
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.acme.p5d2.model.impl;

import com.acme.p5d2.model.P5D2Entry;
import com.acme.p5d2.model.P5D2EntryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the P5D2Entry service. Represents a row in the &quot;P5D2_P5D2Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>P5D2EntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link P5D2EntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see P5D2EntryImpl
 * @generated
 */
public class P5D2EntryModelImpl
	extends BaseModelImpl<P5D2Entry> implements P5D2EntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a p5d2 entry model instance should use the <code>P5D2Entry</code> interface instead.
	 */
	public static final String TABLE_NAME = "P5D2_P5D2Entry";

	public static final Object[][] TABLE_COLUMNS = {
		{"p5d2EntryId", Types.BIGINT}, {"baker", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("p5d2EntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("baker", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table P5D2_P5D2Entry (p5d2EntryId LONG not null primary key,baker VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table P5D2_P5D2Entry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY p5d2Entry.p5d2EntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY P5D2_P5D2Entry.p5d2EntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long P5D2ENTRYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public P5D2EntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _p5d2EntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setP5d2EntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _p5d2EntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return P5D2Entry.class;
	}

	@Override
	public String getModelClassName() {
		return P5D2Entry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<P5D2Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<P5D2Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<P5D2Entry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((P5D2Entry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<P5D2Entry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<P5D2Entry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(P5D2Entry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<P5D2Entry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<P5D2Entry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, P5D2Entry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			P5D2Entry.class.getClassLoader(), P5D2Entry.class,
			ModelWrapper.class);

		try {
			Constructor<P5D2Entry> constructor =
				(Constructor<P5D2Entry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<P5D2Entry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<P5D2Entry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<P5D2Entry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<P5D2Entry, Object>>();
		Map<String, BiConsumer<P5D2Entry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<P5D2Entry, ?>>();

		attributeGetterFunctions.put("p5d2EntryId", P5D2Entry::getP5d2EntryId);
		attributeSetterBiConsumers.put(
			"p5d2EntryId",
			(BiConsumer<P5D2Entry, Long>)P5D2Entry::setP5d2EntryId);
		attributeGetterFunctions.put("baker", P5D2Entry::getBaker);
		attributeSetterBiConsumers.put(
			"baker", (BiConsumer<P5D2Entry, String>)P5D2Entry::setBaker);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getP5d2EntryId() {
		return _p5d2EntryId;
	}

	@Override
	public void setP5d2EntryId(long p5d2EntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_p5d2EntryId = p5d2EntryId;
	}

	@Override
	public String getBaker() {
		if (_baker == null) {
			return "";
		}
		else {
			return _baker;
		}
	}

	@Override
	public void setBaker(String baker) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_baker = baker;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, P5D2Entry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public P5D2Entry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, P5D2Entry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		P5D2EntryImpl p5d2EntryImpl = new P5D2EntryImpl();

		p5d2EntryImpl.setP5d2EntryId(getP5d2EntryId());
		p5d2EntryImpl.setBaker(getBaker());

		p5d2EntryImpl.resetOriginalValues();

		return p5d2EntryImpl;
	}

	@Override
	public P5D2Entry cloneWithOriginalValues() {
		P5D2EntryImpl p5d2EntryImpl = new P5D2EntryImpl();

		p5d2EntryImpl.setP5d2EntryId(
			this.<Long>getColumnOriginalValue("p5d2EntryId"));
		p5d2EntryImpl.setBaker(this.<String>getColumnOriginalValue("baker"));

		return p5d2EntryImpl;
	}

	@Override
	public int compareTo(P5D2Entry p5d2Entry) {
		long primaryKey = p5d2Entry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof P5D2Entry)) {
			return false;
		}

		P5D2Entry p5d2Entry = (P5D2Entry)object;

		long primaryKey = p5d2Entry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<P5D2Entry> toCacheModel() {
		P5D2EntryCacheModel p5d2EntryCacheModel = new P5D2EntryCacheModel();

		p5d2EntryCacheModel.p5d2EntryId = getP5d2EntryId();

		p5d2EntryCacheModel.baker = getBaker();

		String baker = p5d2EntryCacheModel.baker;

		if ((baker != null) && (baker.length() == 0)) {
			p5d2EntryCacheModel.baker = null;
		}

		return p5d2EntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<P5D2Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<P5D2Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<P5D2Entry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((P5D2Entry)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<P5D2Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<P5D2Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<P5D2Entry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((P5D2Entry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, P5D2Entry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _p5d2EntryId;
	private String _baker;

	public <T> T getColumnValue(String columnName) {
		Function<P5D2Entry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((P5D2Entry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("p5d2EntryId", _p5d2EntryId);
		_columnOriginalValues.put("baker", _baker);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("p5d2EntryId", 1L);

		columnBitmasks.put("baker", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private P5D2Entry _escapedModel;

}
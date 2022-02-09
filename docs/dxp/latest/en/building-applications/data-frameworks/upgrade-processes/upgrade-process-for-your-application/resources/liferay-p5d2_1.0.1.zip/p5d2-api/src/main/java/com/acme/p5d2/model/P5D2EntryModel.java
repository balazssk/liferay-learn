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

package com.acme.p5d2.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the P5D2Entry service. Represents a row in the &quot;P5D2_P5D2Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.acme.p5d2.model.impl.P5D2EntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.acme.p5d2.model.impl.P5D2EntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see P5D2Entry
 * @generated
 */
@ProviderType
public interface P5D2EntryModel extends BaseModel<P5D2Entry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p5d2 entry model instance should use the {@link P5D2Entry} interface instead.
	 */

	/**
	 * Returns the primary key of this p5d2 entry.
	 *
	 * @return the primary key of this p5d2 entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p5d2 entry.
	 *
	 * @param primaryKey the primary key of this p5d2 entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the p5d2 entry ID of this p5d2 entry.
	 *
	 * @return the p5d2 entry ID of this p5d2 entry
	 */
	public long getP5d2EntryId();

	/**
	 * Sets the p5d2 entry ID of this p5d2 entry.
	 *
	 * @param p5d2EntryId the p5d2 entry ID of this p5d2 entry
	 */
	public void setP5d2EntryId(long p5d2EntryId);

	/**
	 * Returns the baker of this p5d2 entry.
	 *
	 * @return the baker of this p5d2 entry
	 */
	@AutoEscape
	public String getBaker();

	/**
	 * Sets the baker of this p5d2 entry.
	 *
	 * @param baker the baker of this p5d2 entry
	 */
	public void setBaker(String baker);

	@Override
	public P5D2Entry cloneWithOriginalValues();

}
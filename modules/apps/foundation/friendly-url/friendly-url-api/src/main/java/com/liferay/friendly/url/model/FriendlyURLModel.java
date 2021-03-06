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

package com.liferay.friendly.url.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FriendlyURL service. Represents a row in the &quot;FriendlyURL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.friendly.url.model.impl.FriendlyURLModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.friendly.url.model.impl.FriendlyURLImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FriendlyURL
 * @see com.liferay.friendly.url.model.impl.FriendlyURLImpl
 * @see com.liferay.friendly.url.model.impl.FriendlyURLModelImpl
 * @generated
 */
@ProviderType
public interface FriendlyURLModel extends AttachedModel, BaseModel<FriendlyURL>,
	ShardedModel, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a friendly url model instance should use the {@link FriendlyURL} interface instead.
	 */

	/**
	 * Returns the primary key of this friendly url.
	 *
	 * @return the primary key of this friendly url
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this friendly url.
	 *
	 * @param primaryKey the primary key of this friendly url
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this friendly url.
	 *
	 * @return the uuid of this friendly url
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this friendly url.
	 *
	 * @param uuid the uuid of this friendly url
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the friendly url ID of this friendly url.
	 *
	 * @return the friendly url ID of this friendly url
	 */
	public long getFriendlyURLId();

	/**
	 * Sets the friendly url ID of this friendly url.
	 *
	 * @param friendlyURLId the friendly url ID of this friendly url
	 */
	public void setFriendlyURLId(long friendlyURLId);

	/**
	 * Returns the group ID of this friendly url.
	 *
	 * @return the group ID of this friendly url
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this friendly url.
	 *
	 * @param groupId the group ID of this friendly url
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this friendly url.
	 *
	 * @return the company ID of this friendly url
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this friendly url.
	 *
	 * @param companyId the company ID of this friendly url
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this friendly url.
	 *
	 * @return the create date of this friendly url
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this friendly url.
	 *
	 * @param createDate the create date of this friendly url
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this friendly url.
	 *
	 * @return the modified date of this friendly url
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this friendly url.
	 *
	 * @param modifiedDate the modified date of this friendly url
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this friendly url.
	 *
	 * @return the fully qualified class name of this friendly url
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this friendly url.
	 *
	 * @return the class name ID of this friendly url
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this friendly url.
	 *
	 * @param classNameId the class name ID of this friendly url
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this friendly url.
	 *
	 * @return the class pk of this friendly url
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this friendly url.
	 *
	 * @param classPK the class pk of this friendly url
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the url title of this friendly url.
	 *
	 * @return the url title of this friendly url
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this friendly url.
	 *
	 * @param urlTitle the url title of this friendly url
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the main of this friendly url.
	 *
	 * @return the main of this friendly url
	 */
	public boolean getMain();

	/**
	 * Returns <code>true</code> if this friendly url is main.
	 *
	 * @return <code>true</code> if this friendly url is main; <code>false</code> otherwise
	 */
	public boolean isMain();

	/**
	 * Sets whether this friendly url is main.
	 *
	 * @param main the main of this friendly url
	 */
	public void setMain(boolean main);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(FriendlyURL friendlyURL);

	@Override
	public int hashCode();

	@Override
	public CacheModel<FriendlyURL> toCacheModel();

	@Override
	public FriendlyURL toEscapedModel();

	@Override
	public FriendlyURL toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
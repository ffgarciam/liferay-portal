/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.messageboards.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.documentlibrary.service.DLLocalService;
import com.liferay.documentlibrary.service.DLService;

import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.messageboards.service.MBBanLocalService;
import com.liferay.portlet.messageboards.service.MBBanService;
import com.liferay.portlet.messageboards.service.MBCategoryLocalService;
import com.liferay.portlet.messageboards.service.MBCategoryService;
import com.liferay.portlet.messageboards.service.MBMailingListLocalService;
import com.liferay.portlet.messageboards.service.MBMessageFlagLocalService;
import com.liferay.portlet.messageboards.service.MBMessageFlagService;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.MBStatsUserLocalService;
import com.liferay.portlet.messageboards.service.MBThreadLocalService;
import com.liferay.portlet.messageboards.service.MBThreadService;
import com.liferay.portlet.messageboards.service.persistence.MBBanPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryFinder;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFinder;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFlagFinder;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBThreadFinder;
import com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence;
import com.liferay.portlet.ratings.service.RatingsStatsLocalService;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;
import com.liferay.portlet.social.service.SocialActivityLocalService;
import com.liferay.portlet.social.service.persistence.SocialActivityFinder;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;
import com.liferay.portlet.tags.service.TagsAssetLocalService;
import com.liferay.portlet.tags.service.TagsAssetService;
import com.liferay.portlet.tags.service.persistence.TagsAssetFinder;
import com.liferay.portlet.tags.service.persistence.TagsAssetPersistence;

/**
 * <a href="MBThreadServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class MBThreadServiceBaseImpl extends PrincipalBean
	implements MBThreadService {
	public MBBanLocalService getMBBanLocalService() {
		return mbBanLocalService;
	}

	public void setMBBanLocalService(MBBanLocalService mbBanLocalService) {
		this.mbBanLocalService = mbBanLocalService;
	}

	public MBBanService getMBBanService() {
		return mbBanService;
	}

	public void setMBBanService(MBBanService mbBanService) {
		this.mbBanService = mbBanService;
	}

	public MBBanPersistence getMBBanPersistence() {
		return mbBanPersistence;
	}

	public void setMBBanPersistence(MBBanPersistence mbBanPersistence) {
		this.mbBanPersistence = mbBanPersistence;
	}

	public MBCategoryLocalService getMBCategoryLocalService() {
		return mbCategoryLocalService;
	}

	public void setMBCategoryLocalService(
		MBCategoryLocalService mbCategoryLocalService) {
		this.mbCategoryLocalService = mbCategoryLocalService;
	}

	public MBCategoryService getMBCategoryService() {
		return mbCategoryService;
	}

	public void setMBCategoryService(MBCategoryService mbCategoryService) {
		this.mbCategoryService = mbCategoryService;
	}

	public MBCategoryPersistence getMBCategoryPersistence() {
		return mbCategoryPersistence;
	}

	public void setMBCategoryPersistence(
		MBCategoryPersistence mbCategoryPersistence) {
		this.mbCategoryPersistence = mbCategoryPersistence;
	}

	public MBCategoryFinder getMBCategoryFinder() {
		return mbCategoryFinder;
	}

	public void setMBCategoryFinder(MBCategoryFinder mbCategoryFinder) {
		this.mbCategoryFinder = mbCategoryFinder;
	}

	public MBDiscussionPersistence getMBDiscussionPersistence() {
		return mbDiscussionPersistence;
	}

	public void setMBDiscussionPersistence(
		MBDiscussionPersistence mbDiscussionPersistence) {
		this.mbDiscussionPersistence = mbDiscussionPersistence;
	}

	public MBMailingListLocalService getMBMailingListLocalService() {
		return mbMailingListLocalService;
	}

	public void setMBMailingListLocalService(
		MBMailingListLocalService mbMailingListLocalService) {
		this.mbMailingListLocalService = mbMailingListLocalService;
	}

	public MBMailingListPersistence getMBMailingListPersistence() {
		return mbMailingListPersistence;
	}

	public void setMBMailingListPersistence(
		MBMailingListPersistence mbMailingListPersistence) {
		this.mbMailingListPersistence = mbMailingListPersistence;
	}

	public MBMessageLocalService getMBMessageLocalService() {
		return mbMessageLocalService;
	}

	public void setMBMessageLocalService(
		MBMessageLocalService mbMessageLocalService) {
		this.mbMessageLocalService = mbMessageLocalService;
	}

	public MBMessageService getMBMessageService() {
		return mbMessageService;
	}

	public void setMBMessageService(MBMessageService mbMessageService) {
		this.mbMessageService = mbMessageService;
	}

	public MBMessagePersistence getMBMessagePersistence() {
		return mbMessagePersistence;
	}

	public void setMBMessagePersistence(
		MBMessagePersistence mbMessagePersistence) {
		this.mbMessagePersistence = mbMessagePersistence;
	}

	public MBMessageFinder getMBMessageFinder() {
		return mbMessageFinder;
	}

	public void setMBMessageFinder(MBMessageFinder mbMessageFinder) {
		this.mbMessageFinder = mbMessageFinder;
	}

	public MBMessageFlagLocalService getMBMessageFlagLocalService() {
		return mbMessageFlagLocalService;
	}

	public void setMBMessageFlagLocalService(
		MBMessageFlagLocalService mbMessageFlagLocalService) {
		this.mbMessageFlagLocalService = mbMessageFlagLocalService;
	}

	public MBMessageFlagService getMBMessageFlagService() {
		return mbMessageFlagService;
	}

	public void setMBMessageFlagService(
		MBMessageFlagService mbMessageFlagService) {
		this.mbMessageFlagService = mbMessageFlagService;
	}

	public MBMessageFlagPersistence getMBMessageFlagPersistence() {
		return mbMessageFlagPersistence;
	}

	public void setMBMessageFlagPersistence(
		MBMessageFlagPersistence mbMessageFlagPersistence) {
		this.mbMessageFlagPersistence = mbMessageFlagPersistence;
	}

	public MBMessageFlagFinder getMBMessageFlagFinder() {
		return mbMessageFlagFinder;
	}

	public void setMBMessageFlagFinder(MBMessageFlagFinder mbMessageFlagFinder) {
		this.mbMessageFlagFinder = mbMessageFlagFinder;
	}

	public MBStatsUserLocalService getMBStatsUserLocalService() {
		return mbStatsUserLocalService;
	}

	public void setMBStatsUserLocalService(
		MBStatsUserLocalService mbStatsUserLocalService) {
		this.mbStatsUserLocalService = mbStatsUserLocalService;
	}

	public MBStatsUserPersistence getMBStatsUserPersistence() {
		return mbStatsUserPersistence;
	}

	public void setMBStatsUserPersistence(
		MBStatsUserPersistence mbStatsUserPersistence) {
		this.mbStatsUserPersistence = mbStatsUserPersistence;
	}

	public MBThreadLocalService getMBThreadLocalService() {
		return mbThreadLocalService;
	}

	public void setMBThreadLocalService(
		MBThreadLocalService mbThreadLocalService) {
		this.mbThreadLocalService = mbThreadLocalService;
	}

	public MBThreadService getMBThreadService() {
		return mbThreadService;
	}

	public void setMBThreadService(MBThreadService mbThreadService) {
		this.mbThreadService = mbThreadService;
	}

	public MBThreadPersistence getMBThreadPersistence() {
		return mbThreadPersistence;
	}

	public void setMBThreadPersistence(MBThreadPersistence mbThreadPersistence) {
		this.mbThreadPersistence = mbThreadPersistence;
	}

	public MBThreadFinder getMBThreadFinder() {
		return mbThreadFinder;
	}

	public void setMBThreadFinder(MBThreadFinder mbThreadFinder) {
		this.mbThreadFinder = mbThreadFinder;
	}

	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public CounterService getCounterService() {
		return counterService;
	}

	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

	public DLLocalService getDLLocalService() {
		return dlLocalService;
	}

	public void setDLLocalService(DLLocalService dlLocalService) {
		this.dlLocalService = dlLocalService;
	}

	public DLService getDLService() {
		return dlService;
	}

	public void setDLService(DLService dlService) {
		this.dlService = dlService;
	}

	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public UserFinder getUserFinder() {
		return userFinder;
	}

	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	public RatingsStatsLocalService getRatingsStatsLocalService() {
		return ratingsStatsLocalService;
	}

	public void setRatingsStatsLocalService(
		RatingsStatsLocalService ratingsStatsLocalService) {
		this.ratingsStatsLocalService = ratingsStatsLocalService;
	}

	public RatingsStatsPersistence getRatingsStatsPersistence() {
		return ratingsStatsPersistence;
	}

	public void setRatingsStatsPersistence(
		RatingsStatsPersistence ratingsStatsPersistence) {
		this.ratingsStatsPersistence = ratingsStatsPersistence;
	}

	public SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	public void setSocialActivityLocalService(
		SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	public SocialActivityFinder getSocialActivityFinder() {
		return socialActivityFinder;
	}

	public void setSocialActivityFinder(
		SocialActivityFinder socialActivityFinder) {
		this.socialActivityFinder = socialActivityFinder;
	}

	public TagsAssetLocalService getTagsAssetLocalService() {
		return tagsAssetLocalService;
	}

	public void setTagsAssetLocalService(
		TagsAssetLocalService tagsAssetLocalService) {
		this.tagsAssetLocalService = tagsAssetLocalService;
	}

	public TagsAssetService getTagsAssetService() {
		return tagsAssetService;
	}

	public void setTagsAssetService(TagsAssetService tagsAssetService) {
		this.tagsAssetService = tagsAssetService;
	}

	public TagsAssetPersistence getTagsAssetPersistence() {
		return tagsAssetPersistence;
	}

	public void setTagsAssetPersistence(
		TagsAssetPersistence tagsAssetPersistence) {
		this.tagsAssetPersistence = tagsAssetPersistence;
	}

	public TagsAssetFinder getTagsAssetFinder() {
		return tagsAssetFinder;
	}

	public void setTagsAssetFinder(TagsAssetFinder tagsAssetFinder) {
		this.tagsAssetFinder = tagsAssetFinder;
	}

	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBBanLocalService.impl")
	protected MBBanLocalService mbBanLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBBanService.impl")
	protected MBBanService mbBanService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBBanPersistence.impl")
	protected MBBanPersistence mbBanPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBCategoryLocalService.impl")
	protected MBCategoryLocalService mbCategoryLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBCategoryService.impl")
	protected MBCategoryService mbCategoryService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence.impl")
	protected MBCategoryPersistence mbCategoryPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryFinder.impl")
	protected MBCategoryFinder mbCategoryFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistence.impl")
	protected MBDiscussionPersistence mbDiscussionPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBMailingListLocalService.impl")
	protected MBMailingListLocalService mbMailingListLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistence.impl")
	protected MBMailingListPersistence mbMailingListPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBMessageLocalService.impl")
	protected MBMessageLocalService mbMessageLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBMessageService.impl")
	protected MBMessageService mbMessageService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence.impl")
	protected MBMessagePersistence mbMessagePersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFinder.impl")
	protected MBMessageFinder mbMessageFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBMessageFlagLocalService.impl")
	protected MBMessageFlagLocalService mbMessageFlagLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBMessageFlagService.impl")
	protected MBMessageFlagService mbMessageFlagService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistence.impl")
	protected MBMessageFlagPersistence mbMessageFlagPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFlagFinder.impl")
	protected MBMessageFlagFinder mbMessageFlagFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBStatsUserLocalService.impl")
	protected MBStatsUserLocalService mbStatsUserLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence.impl")
	protected MBStatsUserPersistence mbStatsUserPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBThreadLocalService.impl")
	protected MBThreadLocalService mbThreadLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.MBThreadService.impl")
	protected MBThreadService mbThreadService;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence.impl")
	protected MBThreadPersistence mbThreadPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadFinder.impl")
	protected MBThreadFinder mbThreadFinder;
	@javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
	protected CounterLocalService counterLocalService;
	@javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
	protected CounterService counterService;
	@javax.annotation.Resource(name = "com.liferay.documentlibrary.service.DLLocalService.impl")
	protected DLLocalService dlLocalService;
	@javax.annotation.Resource(name = "com.liferay.documentlibrary.service.DLService.impl")
	protected DLService dlService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.ResourceLocalService.impl")
	protected ResourceLocalService resourceLocalService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.ResourceService.impl")
	protected ResourceService resourceService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
	protected ResourcePersistence resourcePersistence;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.ResourceFinder.impl")
	protected ResourceFinder resourceFinder;
	@javax.annotation.Resource(name = "com.liferay.portal.service.UserLocalService.impl")
	protected UserLocalService userLocalService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.UserService.impl")
	protected UserService userService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
	protected UserPersistence userPersistence;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserFinder.impl")
	protected UserFinder userFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.ratings.service.RatingsStatsLocalService.impl")
	protected RatingsStatsLocalService ratingsStatsLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence.impl")
	protected RatingsStatsPersistence ratingsStatsPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.social.service.SocialActivityLocalService.impl")
	protected SocialActivityLocalService socialActivityLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.social.service.persistence.SocialActivityPersistence.impl")
	protected SocialActivityPersistence socialActivityPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.social.service.persistence.SocialActivityFinder.impl")
	protected SocialActivityFinder socialActivityFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.tags.service.TagsAssetLocalService.impl")
	protected TagsAssetLocalService tagsAssetLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.tags.service.TagsAssetService.impl")
	protected TagsAssetService tagsAssetService;
	@javax.annotation.Resource(name = "com.liferay.portlet.tags.service.persistence.TagsAssetPersistence.impl")
	protected TagsAssetPersistence tagsAssetPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.tags.service.persistence.TagsAssetFinder.impl")
	protected TagsAssetFinder tagsAssetFinder;
}
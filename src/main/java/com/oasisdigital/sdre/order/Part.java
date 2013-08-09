/*
 * Copyright 2012-2013 the original author or authors.
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
package com.oasisdigital.sdre.order;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.oasisdigital.sdre.core.AbstractEntity;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ODPart")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Part extends AbstractEntity {

	private String partNumber;
	private String description;
	private int price;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime orderedDate;

	/**
	 * Creates a new {@link Part} 
	 * 
	 * @param items must not be {@literal null}.
	 * @param location
	 */
	public Part() {
		this.orderedDate = new DateTime();
	}

	public Part(String partNumber, String description, int price) {
		super();
		this.partNumber = partNumber;
		this.description = description;
		this.price = price;
		this.orderedDate = new DateTime();
	}

}

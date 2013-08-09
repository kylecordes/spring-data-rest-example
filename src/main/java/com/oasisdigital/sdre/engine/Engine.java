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
package com.oasisdigital.sdre.engine;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.oasisdigital.sdre.order.Part;
import com.oasisdigital.sdre.order.PartRepository;

/**
 * Simple {@link ApplicationListener} implementation that listens to {@link OrderPaidEvent}s marking the according
 * {@link Part} as in process, sleeping for 10 seconds and marking the order as processed right after that.
 * 
 * @author Oliver Gierke
 */
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class Engine {

	private final @NonNull PartRepository repository;
	private final Set<Part> ordersInProgress = Collections.newSetFromMap(new ConcurrentHashMap<Part, Boolean>());

	public Set<Part> getOrders() {
		return ordersInProgress;
	}

}

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

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Initializer to set up two {@link Part}s.
 * 
 * @author Oliver Gierke
 */
@Service
class PartInitializer {

	/**
	 * Creates two orders and persists them using the given {@link PartRepository}.
	 * 
	 * @param orderRepository must not be {@literal null}.
	 */
	@Autowired
	public PartInitializer(PartRepository orderRepository) {

		Assert.notNull(orderRepository, "OrderRepository must not be null!");

		orderRepository.save(Arrays.asList(
				new Part("1234", "Couch", 1000), 
				new Part("3455", "Chair", 45), 
				new Part("5555", "jicodjcoc bookshelf", 0), 
				new Part("7765", "jhih3diuhihiu3333", 34)));
	}
}

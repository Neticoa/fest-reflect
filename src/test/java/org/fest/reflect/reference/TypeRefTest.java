/*
 * Created on Dec 16, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2012-2013 the original author or authors.
 */
package org.fest.reflect.reference;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link TypeRef}.
 *
 * @author Alex Ruiz
 */
public class TypeRefTest {
  @Test public void should_return_raw_type() {
    TypeRef<List<String>> typeRef = new TypeRef<List<String>>() {
    };
    Class<List<String>> rawType = typeRef.rawType();
    assertEquals(List.class, rawType);
  }
}

/*
 * Created on Aug 17, 2007
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
 * Copyright @2007-2013 the original author or authors.
 */
package org.fest.reflect.method;

import org.fest.reflect.reference.TypeRef;
import org.fest.util.InternalApi;

import javax.annotation.Nonnull;

import static org.fest.util.Preconditions.checkNotNullOrEmpty;

/**
 * Stores the name of the method to invoke via
 * <a href="http://docs.oracle.com/javase/tutorial/reflect/index.html" target="_blank">Java Reflection</a>.
 * <p/>
 * <strong>Note:</strong> To improve code readability, we recommend invoking
 * {@link org.fest.reflect.core.Reflection#method(String) Reflection.method(String)} instead of this class' constructor:
 * <pre>
 * // import static {@link org.fest.reflect.core.Reflection#method(String) org.fest.reflect.core.Reflection.method};
 *
 * // Equivalent to invoking the method 'person.setName("Luke")'
 * {@link org.fest.reflect.core.Reflection#method(String) method}("setName").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
 *                  .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(person)
 *                  .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Luke");
 *
 * // Equivalent to invoking the method 'jedi.getPowers()'
 * List&lt;String&gt; powers = {@link org.fest.reflect.core.Reflection#method(String) method}("getPowers").{@link org.fest.reflect.method.MethodName#withReturnType(org.fest.reflect.reference.TypeRef) withReturnType}(new {@link org.fest.reflect.reference.TypeRef TypeRef}&lt;List&lt;String&gt;&gt;() {})
 *                                          .{@link org.fest.reflect.method.ReturnTypeRef#in(Object) in}(person)
 *                                          .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
 *
 * // Equivalent to invoking the static method 'Jedi.setCommonPower("Jump")'
 * {@link org.fest.reflect.core.Reflection#method(String) method}("setCommonPower").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
 *                         .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(Jedi.class)
 *                         .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Jump");
 *
 * // Equivalent to invoking the static method 'Jedi.addPadawan()'
 * {@link org.fest.reflect.core.Reflection#method(String) method}("addPadawan").{@link org.fest.reflect.method.MethodName#in(Object) in}(Jedi.class).{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
 * </pre>
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public final class MethodName {
  private final String value;

  /**
   * Creates a new {@link MethodName}.
   * <p/>
   * <strong>Note:</strong> To improve code readability, we recommend invoking
   * {@link org.fest.reflect.core.Reflection#method(String) Reflection.method(String)} instead of this constructor:
   * <pre>
   * // import static {@link org.fest.reflect.core.Reflection#method(String) org.fest.reflect.core.Reflection.method};
   *
   * // Equivalent to invoking the method 'person.setName("Luke")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setName").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                  .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(person)
   *                  .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Luke");
   *
   * // Equivalent to invoking the method 'jedi.getPowers()'
   * List&lt;String&gt; powers = {@link org.fest.reflect.core.Reflection#method(String) method}("getPowers").{@link org.fest.reflect.method.MethodName#withReturnType(org.fest.reflect.reference.TypeRef) withReturnType}(new {@link org.fest.reflect.reference.TypeRef TypeRef}&lt;List&lt;String&gt;&gt;() {})
   *                                          .{@link org.fest.reflect.method.ReturnTypeRef#in(Object) in}(person)
   *                                          .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   *
   * // Equivalent to invoking the static method 'Jedi.setCommonPower("Jump")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setCommonPower").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                         .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(Jedi.class)
   *                         .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Jump");
   *
   * // Equivalent to invoking the static method 'Jedi.addPadawan()'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("addPadawan").{@link org.fest.reflect.method.MethodName#in(Object) in}(Jedi.class).{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   * </pre>
   *
   * @param name the name of the method to invoke.
   * @throws NullPointerException     if the method name is {@code null}.
   * @throws IllegalArgumentException if the method name is empty.
   */
  @InternalApi
  public MethodName(@Nonnull String name) {
    this.value = checkNotNullOrEmpty(name);
  }

  /**
   * Specifies the return type of the method to invoke.
   * <p/>
   * <strong>Note:</strong> Invocation of this method is optional if the return type of the method to invoke is
   * {@code void}.
   * <p/>
   * Examples:
   * <pre>
   * // import static {@link org.fest.reflect.core.Reflection#method(String) org.fest.reflect.core.Reflection.method};
   *
   * // Equivalent to invoking the method 'person.setName("Luke")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setName").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                  .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(person)
   *                  .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Luke");
   *
   * // Equivalent to invoking the method 'jedi.getPowers()'
   * List&lt;String&gt; powers = {@link org.fest.reflect.core.Reflection#method(String) method}("getPowers").{@link org.fest.reflect.method.MethodName#withReturnType(org.fest.reflect.reference.TypeRef) withReturnType}(new {@link org.fest.reflect.reference.TypeRef TypeRef}&lt;List&lt;String&gt;&gt;() {})
   *                                          .{@link org.fest.reflect.method.ReturnTypeRef#in(Object) in}(person)
   *                                          .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   *
   * // Equivalent to invoking the static method 'Jedi.setCommonPower("Jump")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setCommonPower").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                         .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(Jedi.class)
   *                         .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Jump");
   *
   * // Equivalent to invoking the static method 'Jedi.addPadawan()'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("addPadawan").{@link org.fest.reflect.method.MethodName#in(Object) in}(Jedi.class).{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   * </pre>
   *
   * @param type the return type of the method to invoke.
   * @return a holder for the method's return type.
   * @throws NullPointerException if the given type is {@code null}.
   */
  public @Nonnull <T> ReturnType<T> withReturnType(@Nonnull Class<T> type) {
    return new ReturnType<T>(checkNotNullOrEmpty(value), type);
  }

  /**
   * Specifies the return type of the method to invoke. This method uses {@link TypeRef} instead of {@link Class} to
   * preserve generic types that otherwise would be lost due to
   * <a href="http://docs.oracle.com/javase/tutorial/java/generics/erasure.html" target="_blank">type erasure</a>.
   * <p/>
   * <strong>Note:</strong> Invocation of this method is optional if the return type of the method to invoke is
   * {@code void}.
   * <p/>
   * Examples:
   * <pre>
   * // import static {@link org.fest.reflect.core.Reflection#method(String) org.fest.reflect.core.Reflection.method};
   *
   * // Equivalent to invoking the method 'person.setName("Luke")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setName").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                  .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(person)
   *                  .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Luke");
   *
   * // Equivalent to invoking the method 'jedi.getPowers()'
   * List&lt;String&gt; powers = {@link org.fest.reflect.core.Reflection#method(String) method}("getPowers").{@link org.fest.reflect.method.MethodName#withReturnType(org.fest.reflect.reference.TypeRef) withReturnType}(new {@link org.fest.reflect.reference.TypeRef TypeRef}&lt;List&lt;String&gt;&gt;() {})
   *                                          .{@link org.fest.reflect.method.ReturnTypeRef#in(Object) in}(person)
   *                                          .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   *
   * // Equivalent to invoking the static method 'Jedi.setCommonPower("Jump")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setCommonPower").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                         .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(Jedi.class)
   *                         .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Jump");
   *
   * // Equivalent to invoking the static method 'Jedi.addPadawan()'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("addPadawan").{@link org.fest.reflect.method.MethodName#in(Object) in}(Jedi.class).{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   * </pre>
   *
   * @param type the return type reference of the method to invoke.
   * @return a holder for the method's return type.
   * @throws NullPointerException if the given type reference is {@code null}.
   * @since 1.1
   */
  public @Nonnull <T> ReturnTypeRef<T> withReturnType(@Nonnull TypeRef<T> type) {
    return new ReturnTypeRef<T>(value, type);
  }

  /**
   * Specifies the parameter types of the method to invoke.
   * <p/>
   * <strong>Note:</strong> Invocation of this method is optional if the method to invoke does not take any arguments.
   * <p/>
   * Examples:
   * <pre>
   * // import static {@link org.fest.reflect.core.Reflection#method(String) org.fest.reflect.core.Reflection.method};
   *
   * // Equivalent to invoking the method 'person.setName("Luke")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setName").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                  .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(person)
   *                  .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Luke");
   *
   * // Equivalent to invoking the method 'jedi.getPowers()'
   * List&lt;String&gt; powers = {@link org.fest.reflect.core.Reflection#method(String) method}("getPowers").{@link org.fest.reflect.method.MethodName#withReturnType(org.fest.reflect.reference.TypeRef) withReturnType}(new {@link org.fest.reflect.reference.TypeRef TypeRef}&lt;List&lt;String&gt;&gt;() {})
   *                                          .{@link org.fest.reflect.method.ReturnTypeRef#in(Object) in}(person)
   *                                          .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   *
   * // Equivalent to invoking the static method 'Jedi.setCommonPower("Jump")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setCommonPower").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                         .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(Jedi.class)
   *                         .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Jump");
   *
   * // Equivalent to invoking the static method 'Jedi.addPadawan()'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("addPadawan").{@link org.fest.reflect.method.MethodName#in(Object) in}(Jedi.class).{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   * </pre>
   *
   * @param parameterTypes the parameter types of the method to invoke.
   * @return a holder for the method's parameter types.
   * @throws NullPointerException if the array of parameter types is {@code null}.
   */
  public @Nonnull ParameterTypes<Void> withParameterTypes(@Nonnull Class<?>... parameterTypes) {
    return new ParameterTypes<Void>(value, Void.class, parameterTypes);
  }

  /**
   * Specifies the object or class containing the method to invoke. The method to invoke does not take any parameters
   * and its return type is {@code void}.
   * <p/>
   * Examples:
   * <pre>
   * // import static {@link org.fest.reflect.core.Reflection#method(String) org.fest.reflect.core.Reflection.method};
   *
   * // Equivalent to invoking the method 'person.setName("Luke")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setName").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                  .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(person)
   *                  .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Luke");
   *
   * // Equivalent to invoking the method 'jedi.getPowers()'
   * List&lt;String&gt; powers = {@link org.fest.reflect.core.Reflection#method(String) method}("getPowers").{@link org.fest.reflect.method.MethodName#withReturnType(org.fest.reflect.reference.TypeRef) withReturnType}(new {@link org.fest.reflect.reference.TypeRef TypeRef}&lt;List&lt;String&gt;&gt;() {})
   *                                          .{@link org.fest.reflect.method.ReturnTypeRef#in(Object) in}(person)
   *                                          .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   *
   * // Equivalent to invoking the static method 'Jedi.setCommonPower("Jump")'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("setCommonPower").{@link org.fest.reflect.method.MethodName#withParameterTypes(Class...) withParameterTypes}(String.class)
   *                         .{@link org.fest.reflect.method.ParameterTypes#in(Object) in}(Jedi.class)
   *                         .{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}("Jump");
   *
   * // Equivalent to invoking the static method 'Jedi.addPadawan()'
   * {@link org.fest.reflect.core.Reflection#method(String) method}("addPadawan").{@link org.fest.reflect.method.MethodName#in(Object) in}(Jedi.class).{@link org.fest.reflect.method.MethodInvoker#invoke(Object...) invoke}();
   * </pre>
   *
   * @param target the object containing the method to invoke. To invoke a static method, pass a class instead.
   * @return the created method invoker.
   * @throws NullPointerException if the given target is {@code null}.
   */
  public @Nonnull MethodInvoker<Void> in(@Nonnull Object target) {
    return new MethodInvoker<Void>(value, Void.class, new Class<?>[0], target);
  }
}
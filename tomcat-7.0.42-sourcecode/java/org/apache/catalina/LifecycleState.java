/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.catalina;

/**
 * The list of valid states for components that implement {@link Lifecycle}.
 * See {@link Lifecycle} for the state transition diagram.
 */

/**
 * Tomcat的容器的状态
 */
public enum LifecycleState {
    /**
     * 容器刚刚创建时，即在LifecycleBase实例构造完成时的状态
     */
    NEW(false, null),

    /**
     *
     */
    INITIALIZING(false, Lifecycle.BEFORE_INIT_EVENT),

    /**
     * 容器初始化完成时的状态
     */
    INITIALIZED(false, Lifecycle.AFTER_INIT_EVENT),

    /**
     * 容器启动前的状态
     */
    STARTING_PREP(false, Lifecycle.BEFORE_START_EVENT),

    /**
     * 容器启动过程中的状态
     */
    STARTING(true, Lifecycle.START_EVENT),

    /**
     * 容器启动过程中的状态
     */
    STARTED(true, Lifecycle.AFTER_START_EVENT),

    /**
     * 容器停止前的状态
     */
    STOPPING_PREP(true, Lifecycle.BEFORE_STOP_EVENT),

    /**
     * 容器停止过程中的状态
     */
    STOPPING(false, Lifecycle.STOP_EVENT),

    /**
     * 容器停止完成的状态
     */
    STOPPED(false, Lifecycle.AFTER_STOP_EVENT),

    /**
     * 容器销毁过程中的状态
     */
    DESTROYING(false, Lifecycle.BEFORE_DESTROY_EVENT),

    /**
     * 容器销毁后的状态
     */
    DESTROYED(false, Lifecycle.AFTER_DESTROY_EVENT),

    /**
     * 容器启动、停止过程中出现异常的状态
     */
    FAILED(false, null),


    MUST_STOP(true, null),
    MUST_DESTROY(false, null);

    private final boolean available;
    private final String lifecycleEvent;

    private LifecycleState(boolean available, String lifecycleEvent) {
        this.available = available;
        this.lifecycleEvent = lifecycleEvent;
    }

    /**
     * May the public methods other than property getters/setters and lifecycle
     * methods be called for a component in this state? It returns
     * <code>true</code> for any component in any of the following states:
     * <ul>
     * <li>{@link #STARTING}</li>
     * <li>{@link #STARTED}</li>
     * <li>{@link #STOPPING_PREP}</li>
     * <li>{@link #MUST_STOP}</li>
     * </ul>
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     *
     */
    public String getLifecycleEvent() {
        return lifecycleEvent;
    }
}

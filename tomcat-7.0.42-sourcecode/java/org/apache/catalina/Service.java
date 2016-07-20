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

import org.apache.catalina.connector.Connector;

/**
 * A <strong>Service</strong> is a group of one or more
 * <strong>Connectors</strong> that share a single <strong>Container</strong>
 * to process their incoming requests.  This arrangement allows, for example,
 * a non-SSL and SSL connector to share the same population of web apps.
 * <p>
 * A given JVM can contain any number of Service instances; however, they are
 * completely independent of each other and share only the basic JVM facilities
 * and classes on the system class path.
 *
 * @author Craig R. McClanahan
 * @version $Id: Service.java 1200162 2011-11-10 05:37:57Z kkolinko $
 */

/**
 * Service 组装 Connector 和 Container，对外提供服务
 */
public interface Service extends Lifecycle {

    // ------------------------------------------------------------- Properties


    /**
     * Return the <code>Container</code> that handles requests for all
     * <code>Connectors</code> associated with this Service.
     */
    /**
     * 返回Container
     * @return
     */
    public Container getContainer();

    /**
     * Set the <code>Container</code> that handles requests for all
     * <code>Connectors</code> associated with this Service.
     *
     * @param container The new Container
     */
    public void setContainer(Container container);

    /**
     * Return descriptive information about this Service implementation and
     * the corresponding version number, in the format
     * <code>&lt;description&gt;/&lt;version&gt;</code>.
     */
    /**
     * 返回Service实现类的描述信息及格式化后的的对面版本号
     * @return
     */
    public String getInfo();

    /**
     * Return the name of this Service.
     */
    /**
     * 返回Service的名称
     * @return
     */
    public String getName();

    /**
     * Set the name of this Service.
     *
     * @param name The new service name
     */
    /**
     * 设置Service的名称
     * @param name
     */
    public void setName(String name);

    /**
     * Return the <code>Server</code> with which we are associated (if any).
     */
    public Server getServer();

    /**
     * Set the <code>Server</code> with which we are associated (if any).
     *
     * @param server The server that owns this Service
     */
    public void setServer(Server server);

    /**
     * Return the parent class loader for this component. If not set, return
     * {@link #getServer()} {@link Server#getParentClassLoader()}. If no server
     * has been set, return the system class loader.
     */
    /**
     * 获取父类的类加载器
     * @return
     */
    public ClassLoader getParentClassLoader();

    /**
     * Set the parent class loader for this service.
     *
     * @param parent The new parent class loader
     */
    /**
     * 设置父类的类加载器
     * @param parent
     */
    public void setParentClassLoader(ClassLoader parent);

    // --------------------------------------------------------- Public Methods


    /**
     * Add a new Connector to the set of defined Connectors, and associate it
     * with this Service's Container.
     *
     * @param connector The Connector to be added
     */
    /**
     * 添加Connector
     * @param connector
     */
    public void addConnector(Connector connector);

    /**
     * Find and return the set of Connectors associated with this Service.
     */
    /**
     * 获取所有的Connector
     * @return
     */
    public Connector[] findConnectors();

    /**
     * Remove the specified Connector from the set associated from this
     * Service.  The removed Connector will also be disassociated from our
     * Container.
     *
     * @param connector The Connector to be removed
     */
    /**
     * 移除Connector
     * @param connector
     */
    public void removeConnector(Connector connector);

    /**
     * Adds a named executor to the service
     * @param ex Executor
     */
    /**
     * 添加线程池
     * @param ex
     */
    public void addExecutor(Executor ex);

    /**
     * Retrieves all executors
     * @return Executor[]
     */
    /**
     * 获取所有的线程池组
     * @return
     */
    public Executor[] findExecutors();

    /**
     * Retrieves executor by name, null if not found
     * @param name String
     * @return Executor
     */
    /**
     * 根据名称获取线程池(没找到返回null)
     *
     * @param name
     * @return
     */
    public Executor getExecutor(String name);

    /**
     * Removes an executor from the service
     * @param ex Executor
     */
    /**
     * 移除线程池
     * @param ex
     */
    public void removeExecutor(Executor ex);

}

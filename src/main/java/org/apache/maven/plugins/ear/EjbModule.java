package org.apache.maven.plugins.ear;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.artifact.Artifact;
import org.codehaus.plexus.util.xml.XMLWriter;

/**
 * The {@link EarModule} implementation for an EJB module.
 * 
 * @author <a href="snicoll@apache.org">Stephane Nicoll</a>
 */
public class EjbModule
    extends AbstractEarModule
{
    private static final String DEFAULT_ARTIFACT_TYPE = "ejb";

    private static final String EJB_MODULE = "ejb";

    /**
     * Create an instance.
     */
    public EjbModule()
    {
        this.type = DEFAULT_ARTIFACT_TYPE;
    }

    /**
     * @param a {@link Artifact}
     */
    public EjbModule( Artifact a )
    {
        super( a );
    }

    /**
     * {@inheritDoc}
     */
    public void appendModule( XMLWriter writer, String version, Boolean generateId )
    {
        startModuleElement( writer, generateId );
        writer.startElement( EJB_MODULE );
        writer.writeText( getUri() );
        writer.endElement();

        writeAltDeploymentDescriptor( writer, version );

        writer.endElement();
    }
}

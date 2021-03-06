/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.spi.copy;

import org.ehcache.config.copy.DefaultCopyProviderConfiguration;
import org.ehcache.spi.service.ServiceCreationConfiguration;
import org.ehcache.spi.service.ServiceFactory;

/**
 * @author Albin Suresh
 */
public class DefaultCopyProviderFactory implements ServiceFactory<CopyProvider> {

  @Override
  public CopyProvider create(final ServiceCreationConfiguration<CopyProvider> configuration) {
    if (configuration != null && !(configuration instanceof DefaultCopyProviderConfiguration)) {
      throw new IllegalArgumentException("Expected a configuration of type DefaultCopyProviderConfiguration but got "
                                         + configuration.getClass().getSimpleName());
    }

    return new DefaultCopyProvider((DefaultCopyProviderConfiguration) configuration);
  }

  @Override
  public Class<CopyProvider> getServiceType() {
    return CopyProvider.class;
  }
}

/*
 * Copyright The Microcks Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.microcks.operator.base.resources;

import io.github.microcks.operator.api.base.v1alpha1.Microcks;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.dependent.DependentResource;
import io.javaoperatorsdk.operator.processing.dependent.workflow.Condition;

/**
 * A reconciliation pre-condition that is only met if Keycloak module should be installed.
 * @author laurent
 */
public class KeycloakInstallPrecondition implements Condition<HasMetadata, Microcks> {

   @Override
   public boolean isMet(DependentResource<HasMetadata, Microcks> dependentResource, Microcks microcks,
         Context<Microcks> context) {
      return microcks.getSpec().getKeycloak().isInstall() && microcks.getStatus().getKeycloakUrl() != null;
   }
}

/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.golike.seamedicalapp.component;

import android.content.Context;

import com.golike.seamedicalapp.api.SeaMedicalApi;
import com.golike.seamedicalapp.module.AppModule;
import com.golike.seamedicalapp.module.SeaMedicalApiModule;

import dagger.Component;

@Component(modules = {AppModule.class, SeaMedicalApiModule.class})
public interface AppComponent {

    Context getContext();

    SeaMedicalApi getSeaMedicalApi();

}
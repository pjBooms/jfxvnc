package org.jfxvnc.ui.presentation.connect;

/*
 * #%L
 * jfxvnc-ui
 * %%
 * Copyright (C) 2015 comtel2000
 * %%
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
 * #L%
 */

import static org.junit.Assert.assertNotNull;

import org.jfxvnc.net.rfb.render.DefaultProtocolConfiguration;
import org.jfxvnc.net.rfb.render.ProtocolConfiguration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import com.airhacks.afterburner.injection.Injector;

public class ConnectViewTest {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ConnectViewTest.class);

    @BeforeClass
    public static void init() {
	Injector.setLogger((t) -> logger.info(t));
	Injector.setModelOrService(ProtocolConfiguration.class, Injector.instantiateModelOrService(DefaultProtocolConfiguration.class));
    }

    public static void end() {
	Injector.forgetAll();
    }

    @Test
    public void connectView() {

	ConnectViewPresenter presenter = (ConnectViewPresenter) Injector.instantiatePresenter(ConnectViewPresenter.class);
	assertNotNull(presenter);

    }

}

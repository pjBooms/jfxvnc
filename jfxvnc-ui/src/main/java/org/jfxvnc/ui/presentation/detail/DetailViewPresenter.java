package org.jfxvnc.ui.presentation.detail;

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

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.jfxvnc.ui.persist.SessionContext;
import org.jfxvnc.ui.presentation.about.AboutView;
import org.jfxvnc.ui.presentation.connect.ConnectView;
import org.jfxvnc.ui.presentation.info.InfoView;
import org.jfxvnc.ui.service.VncRenderService;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

public class DetailViewPresenter implements Initializable {

    @Inject
    SessionContext ctx;

    @Inject
    VncRenderService con;

    @FXML
    private Accordion detailPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

	ConnectView connectView = new ConnectView();
	InfoView infoView = new InfoView();
	AboutView aboutView = new AboutView();

	detailPane.getPanes().addAll((TitledPane) connectView.getView(), (TitledPane) infoView.getView(), (TitledPane) aboutView.getView());
	detailPane.setExpandedPane((TitledPane) connectView.getView());

	detailPane.expandedPaneProperty().addListener((observable, oldValue, newValue) -> Platform.runLater(() -> {
	    if (detailPane.getExpandedPane() == null) {
		// keep first view open
		detailPane.setExpandedPane(detailPane.getPanes().get(0));
	    }
	}));
    }

}

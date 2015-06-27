/*
 * Copyright 2013 Google Inc.
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

package com.example.android.wizardpager;

import com.example.android.wizardpager.wizard.model.AbstractWizardModel;
import com.example.android.wizardpager.wizard.model.BranchPage;
import com.example.android.wizardpager.wizard.model.CustomerInfoPage;
import com.example.android.wizardpager.wizard.model.InstructionPage;
import com.example.android.wizardpager.wizard.model.MultipleFixedChoicePage;
import com.example.android.wizardpager.wizard.model.PageList;
import com.example.android.wizardpager.wizard.model.SingleFixedChoicePage;

import android.content.Context;

public class SandwichWizardModel extends AbstractWizardModel {
    public SandwichWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(

                // BranchPage shows all of the branches available: Branch One, Branch Two, Branch Three. Each of these branches
                // have their own questions and the choices of the user will be summarised in the review section at the end
                new BranchPage(this, "Select one options")
                        .addBranch("Branch One",
                                new SingleFixedChoicePage(this, "Question One")
                                        .setChoices("A", "B", "C", "D")
                                        .setRequired(true),

                                new MultipleFixedChoicePage(this, "Question Two")
                                        .setChoices("A", "B", "C", "D",
                                                "E")
                        )

                                // Second branch of questions
                        .addBranch("Branch Two",
                                new SingleFixedChoicePage(this, "Question One")
                                        .setChoices("A", "B")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Question Two")
                                        .setChoices("A", "B", "C",
                                                "D", "E", "F")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Question Three")
                                        .setChoices("A", "B", "C")
                        )

                                // Third branch of questions
                        .addBranch("Branch Three",
                                new InstructionPage(this, "Info"),

                                new SingleFixedChoicePage(this, "Question One")
                                        .setChoices("A", "B", "C")
                                        .setRequired(true)
                        )
        );
    }
}

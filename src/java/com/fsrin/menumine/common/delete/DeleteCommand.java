/*

 Five Sticks
 6957 W. North Ave., #202
 Chicago, IL 60302
 USA
 http://www.fivesticks.com
 mailto:info@fivesticks.com

 Copyright (c) 2003-2005, Five Sticks Publications, Inc.
 All rights reserved.

 Redistribution and use in source and binary forms, 
 with or without modification, are permitted provided
 that the following conditions are met:

 * Redistributions of source code must retain 
 the above copyright notice, this list of conditions 
 and the following disclaimer.
 * Redistributions in binary form must reproduce 
 the above copyright notice, this list of conditions 
 and the following disclaimer in the documentation 
 and/or other materials provided with the distribution.
 * Neither the name of the Five Sticks Publications, Inc.,
 nor the names of its contributors may be used to 
 endorse or promote products derived from this software 
 without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND 
 CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 SUCH DAMAGE.

 license: http://www.opensource.org/licenses/bsd-license.php

 This software uses a variety of Open Source software as
 a foundation.  See the file 

 [your install]/WEB-INF/component-acknowledgement.txt
 
 For more information.
 */
/*
 * Created on 2005-1-14
 */
package com.fsrin.menumine.common.delete;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.fsrin.menumine.common.SurrogateIdReadableObject;
import com.fsrin.menumine.context.MenuMineSessionContext;

/**
 * <p>
 * This is to be extended by the class specific delete command.
 * 
 * @author Nick
 *  
 */
public abstract class DeleteCommand {

    protected boolean executed = false;

    private PlatformTransactionManager transactionManager;

    private SurrogateIdReadableObject target;

    public void delete(final MenuMineSessionContext sessionContext)
            throws DeleteCommandFailedException {

        if (executed)
            throw new DeleteCommandFailedException("already executed!");

        executed = true;

        if (this.getTransactionManager() == null) {
            this.handleDelete(sessionContext);
            return;
        }

        try {
            TransactionTemplate transactionTemplate = new TransactionTemplate(
                    this.getTransactionManager());

            transactionTemplate
                    .setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                public void doInTransactionWithoutResult(
                        TransactionStatus status) {

                    try {
                        handleDelete(sessionContext);
                    } catch (DeleteCommandFailedException e) {
                        throw new RuntimeException();
                    }

                }
            });

        } catch (RuntimeException e) {
            throw new DeleteCommandFailedException(e);
        }

    }

    protected abstract void handleDelete(MenuMineSessionContext sessionContext)
            throws DeleteCommandFailedException;

    public abstract String getTargetDescription()
            throws DeleteCommandFailedException;

    public abstract String getEffectDescription()
            throws DeleteCommandFailedException;

    public abstract String getXWorkSuccess()
            throws DeleteCommandFailedException;

    public SurrogateIdReadableObject getTarget() {
        return target;
    }

    public void setTarget(SurrogateIdReadableObject target) {
        this.target = target;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(
            PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
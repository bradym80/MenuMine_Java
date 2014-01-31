/*

 Five Sticks
 6957 W. North Ave., #202
 Chicago, IL 60302
 USA
 http://www.fivesticks.com
 mailto:info@fivesticks.com

 Copyright (c) 2003-2004, Five Sticks Publications, Inc.
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
 * Created on Jun 4, 2003
 *
 */
package com.fstx.stdlib2.authen.scripts;

/**
 * For a transaction script, it either succeeds or fails. If it fails, it should
 * rollback and alert the user that it failed.
 * 
 * If the rollback fails, then it is possible to throw a further exception,
 * execute and rollback failed. This should only happen in extreme
 * circumstances.
 * 
 * Command Pattern.
 * 
 * @author Reid S Carlberg
 * @version 1.0.0
 */
public abstract class AbstractTransactionScript {

    /**
     * if this needs to be overridden, then we are not dealing with a
     * transaction script.
     */
    public final void execute() throws TransactionScriptFailedException,
            TransactionScriptExecuteAndRollbackFailedException {

        try {
            handleExecute();
        } catch (TransactionScriptExecuteFailedException e) {
            try {
                handleRollback();
                throw new TransactionScriptFailedException();
            } catch (TransactionScriptRollbackFailedException e1) {
                throw new TransactionScriptExecuteAndRollbackFailedException();
            }
        }

    }

    /**
     * this should never be overridden.
     * 
     * @throws TransactionScriptExecuteFailedException
     */
    private void handleExecute() throws TransactionScriptExecuteFailedException {

        if (!handlePreconditions())
            throw new TransactionScriptExecuteFailedException();

        if (!handleRun())
            throw new TransactionScriptExecuteFailedException();

        if (!handlePostconditions())
            throw new TransactionScriptExecuteFailedException();

    }

    /**
     * should be overridden.
     * 
     * @return
     */
    protected abstract boolean handlePreconditions();

    /**
     * should be overridden.
     * 
     * @return
     */
    protected abstract boolean handlePostconditions();

    protected abstract boolean handleRun();

    /**
     * Rollback should always be handled the same way.
     */
    private void handleRollback()
            throws TransactionScriptRollbackFailedException {

        if (!handleRollbackPreconditions())
            throw new TransactionScriptRollbackFailedException();

        if (!handleRollbackRun())
            throw new TransactionScriptRollbackFailedException();

        if (!handleRollbackPostconditions())
            throw new TransactionScriptRollbackFailedException();

    }

    protected abstract boolean handleRollbackPostconditions();

    protected abstract boolean handleRollbackRun();

    protected abstract boolean handleRollbackPreconditions();

}
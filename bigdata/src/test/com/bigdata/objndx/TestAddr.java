/**

The Notice below must appear in each file of the Source Code of any
copy you distribute of the Licensed Product.  Contributors to any
Modifications may add their own copyright notices to identify their
own contributions.

License:

The contents of this file are subject to the CognitiveWeb Open Source
License Version 1.1 (the License).  You may not copy or use this file,
in either source code or executable form, except in compliance with
the License.  You may obtain a copy of the License from

  http://www.CognitiveWeb.org/legal/license/

Software distributed under the License is distributed on an AS IS
basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See
the License for the specific language governing rights and limitations
under the License.

Copyrights:

Portions created by or assigned to CognitiveWeb are Copyright
(c) 2003-2003 CognitiveWeb.  All Rights Reserved.  Contact
information for CognitiveWeb is available at

  http://www.CognitiveWeb.org

Portions Copyright (c) 2002-2003 Bryan Thompson.

Acknowledgements:

Special thanks to the developers of the Jabber Open Source License 1.0
(JOSL), from which this License was derived.  This License contains
terms that differ from JOSL.

Special thanks to the CognitiveWeb Open Source Contributors for their
suggestions and support of the Cognitive Web.

Modifications:

*/
/*
 * Created on Dec 14, 2006
 */

package com.bigdata.objndx;

import java.util.Random;

import junit.framework.TestCase;


public class TestAddr extends TestCase {

    public TestAddr() {
        
    }
    
    public TestAddr(String name) {
        super(name);
    }
    
    public void doRoundTrip( int nbytes, int offset ) {
        
        final long lval = Addr.toLong(nbytes,offset);

        TestIndexSegmentBuilderStatics.assertEquals("nbytes(lval="+Long.toHexString(lval)+")", nbytes, Addr.getByteCount(lval));

        TestIndexSegmentBuilderStatics.assertEquals("offset(lval="+Long.toHexString(lval)+")", offset, Addr.getOffset(lval));

    }

    /**
     * Spot tests round trip of some values.
     */
    public void test_toLong01() {

        doRoundTrip(1, 1);
        
        doRoundTrip(0xaa, 0xff);
        
    }

    /**
     * Test of {@link Addr#toLong(int nbytes, int offset)}.
     */
    public void test_toLong02() {
        
        Random r = new Random();
        
        final int limit = 100000;
        
        for( int i=0; i<limit; i++ ) {

            final int nbytes = r.nextInt(Integer.MAX_VALUE-1)+1;
            
            final int offset = r.nextInt(Integer.MAX_VALUE);

            doRoundTrip( nbytes, offset );
            
        }
        
    }

}
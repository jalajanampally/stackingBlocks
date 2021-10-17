package com.anz.sb.unit.service;

import com.anz.sb.model.RequestBlock;
import com.anz.sb.model.SbRequest;
import com.anz.sb.service.StackingBlocksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class StackingBlocksServiceTest {

    @InjectMocks
    StackingBlocksService stackingBlocksService;

    @Spy
    SbRequest sbRequest;

    @Test
    public void testFindMaximumHeightExample1() {
        RequestBlock requestBlock1 = new RequestBlock(50,45,20);
        sbRequest.setRequestBlockList(Arrays.asList(new RequestBlock(50,45,20)
                , new RequestBlock(95,37,53)
                , new RequestBlock(45,23,12)));
        Assertions.assertEquals("190",stackingBlocksService.findMaximumHeight(sbRequest).getMaxHeight());
    }

    @Test
    public void testFindMaximumHeightExample2() {
        sbRequest.setRequestBlockList(Arrays.asList(new RequestBlock(38,25,45)
                , new RequestBlock(76,35,3)));
        Assertions.assertEquals("76",stackingBlocksService.findMaximumHeight(sbRequest).getMaxHeight());
    }

    @Test
    public void testFindMaximumHeightExample3() {
        sbRequest.setRequestBlockList(Arrays.asList(new RequestBlock(7,11,17)
                , new RequestBlock(7,11,17)
                , new RequestBlock(11,7,17)
                , new RequestBlock(11,17,7)
                , new RequestBlock(17,7,11)
                , new RequestBlock(17,11,7)));
        Assertions.assertEquals("102",stackingBlocksService.findMaximumHeight(sbRequest).getMaxHeight());
    }
}

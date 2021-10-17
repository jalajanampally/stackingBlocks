package com.anz.sb.service;

import com.anz.sb.model.Block;
import com.anz.sb.model.RequestBlock;
import com.anz.sb.model.SbRequest;
import com.anz.sb.model.SbResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Service
@RequiredArgsConstructor
@Slf4j
public class StackingBlocksService {

    public SbResponse findMaximumHeight(SbRequest sbRequest) {
        log.debug("Inside findMaximumHeight service method");
        List<Block> blockList = getBlockList(sbRequest.getRequestBlockList());
        Collections.sort(blockList);
        log.debug("sorted blocklist"+blockList);
        int n = blockList.size();
        int maxHeight = 0;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (blockList.get(i).getWidth() >= blockList.get(j).getWidth()
                        && blockList.get(i).getHeight() >= blockList.get(j).getHeight()) {
                    max = dp[j] > max ? dp[j] : max;
                }
            }
            dp[i] = max + blockList.get(i).getLength();
            maxHeight = dp[i] > maxHeight ? dp[i] : maxHeight;
        }
        log.debug("maximum stacked blocks height is: "+ maxHeight);
        return SbResponse.builder().maxHeight(String.valueOf(maxHeight)).build();
    }

    private List<Block> getBlockList(List<RequestBlock> requestBlocks) {
        ArrayList<Block> blocks = new ArrayList<>();
        log.debug("converting RequestBlock to Block to re-arrange the block with largest side");
        requestBlocks.stream().forEach(requestBlock -> blocks.add(new Block(requestBlock.getLength(), requestBlock.getWidth(), requestBlock.getHeight())));
        return blocks;
    }
}

package com.anz.sb.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Block implements Comparable {
    private int length;
    private int width;
    private int height;

/* re-arranging blocks with the largest side using comparator */
    public Block(int a, int b, int c) {
        if (a >= b && a >= c) {
            length = a;
            if (b >= c) {
                width = b;
                height = c;
            } else {
                width = c;
                height = b;
            }
        } else {
            if (b >= c) {
                length = b;
                if (a >= c) {
                    width = a;
                    height = c;
                } else {
                    width = c;
                    height = a;
                }
            } else {
                length = c;
                if (a >= b) {
                    width = a;
                    height = b;
                } else {
                    width = b;
                    height = a;
                }
            }
        }

    }

    public int compareTo(Object obj) {
        Block block = (Block) obj;
        if (block.length != this.length) {
            return block.length - this.length;
        } else if (block.width != this.width) {
            return block.width - this.width;
        } else if (block.height != this.height) {
            return block.height - this.height;
        } else {
            return 0;
        }
    }

}
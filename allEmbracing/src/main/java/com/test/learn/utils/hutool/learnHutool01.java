package com.test.learn.utils.hutool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: learn01
 * @ProjectName learnGit
 * @date 2023/2/8 10:25
 */
@Slf4j
public class learnHutool01 {

    public static void main(String[] args) {
        log.info("ObjectId:{}", ObjectId.next());
        log.info("ObjectId2:{}", ObjectId.nextWithUnderline());

        for (int i = 0; i <20 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    log.info("ObjectId:{}", ObjectId.next());
                }
            }).start();
        }
    }


}

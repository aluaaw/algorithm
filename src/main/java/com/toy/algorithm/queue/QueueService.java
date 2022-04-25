package com.toy.algorithm.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class QueueService {
    // TODO: qSize를 정해두고 해당 값을 infinity로 사용할 수 있도록 하라.
    private final int size = 10;
    private int inputPosition = 0;
    private int outputPosition = 0;
    private final int[] queueArray = new int[size];

    public void circularQueue_enqueue(int value) {
        System.out.println("START enQueue --------");
        enQueue(value);
    }

    public void circularQueue_dequeue() {
        System.out.println("START deQueue --------");
        deQueue();
    }

    // position index 초기화
    public void initQueue() {
        System.out.println("init QUEUE");
        inputPosition = 0;
        outputPosition = 0;
    }

    // 큐 포화상태
    public boolean isFull() {
        System.out.println("CHECK FULL");
        System.out.println("END OF FULL ------------");
        System.out.println("input : " + inputPosition);
        System.out.println("output : " + outputPosition);
        if (inputPosition != 0) {
            for (int queue : queueArray) {
                if (queue == 0) {
                    System.out.println("포화상태가 아님");
                    return false;
                }
            }
            System.out.println("초기값이 아니지만 포화상태");
            return true;
        }
        // 초기값
        return !(inputPosition == outputPosition);
    }

    // 큐 공백상태
    public boolean isEmpty() {
        System.out.println("CHECK EMPTY");
        System.out.println("END OF EMPTY ------------");
        System.out.println("input : " + inputPosition);
        System.out.println("output : " + outputPosition);
        if (outputPosition != 0) {
            for (int queue : queueArray) {
                if (queue != 0) {
                    System.out.println("공백상태가 아님");
                    return false;
                }
            }
            System.out.println("초기값이 아니지만 공백상태");
            return true;
        }
        // 초기값
        return inputPosition == outputPosition;
    }

    // 큐의 삽입연산
    public boolean enQueue(int value) {
        // 큐의 포화상태 확인, 포화상태일 때에는 더 이상 넣을 수 없음
        if (isFull()) {
            System.out.println("FULL IS TRUE");
            return false;
        }
        // 처음일 경우 초기화
        if (inputPosition == -1) {
            initQueue();
        }

        // 추가처리
        queueArray[inputPosition] = value;
        inputPosition = inputPosition + 1;
        System.out.println("after enQueue, input is " + inputPosition);
        System.out.println("queue is " + Arrays.toString(queueArray));

        // position이 동일할 때 초기화한다.
        if (inputPosition == outputPosition) {
            initQueue();
        }

        return true;
    }

    public boolean deQueue() {
        // 큐의 공백상태 확인, 공백상태일 때에는 더 이상 삭제할 수 없음
        if (isEmpty()) {
            System.out.println("EMPTY IS TRUE");
            return false;
        }

        // 값 출력
        queueArray[outputPosition] = 0;
        outputPosition = outputPosition + 1;

        // position이 동일할 때 초기화한다.
        if (inputPosition == outputPosition) {
            initQueue();
        }

        System.out.println("after deQueue, input is " + inputPosition);
        System.out.println("after deQueue, output is " + outputPosition);
        System.out.println("queue is " + Arrays.toString(queueArray));
        return true;
    }
}

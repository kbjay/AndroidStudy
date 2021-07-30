package com.kbjay.fragment.flag

class Bean {
    private var mFlag = 0

    companion object {
        const val FLAG_A = 0x1
        const val FLAG_B = 0x2
        const val FLAG_C = 0x4
        const val FLAG_D = 0x8
        const val FLAG_E = 0x10
        const val FLAG_F = 0x20
        const val FLAG_G = 0x40
        const val FLAG_H = 0x80
    }

    fun addFlag(flag: Int) {
        // &
        mFlag = mFlag or flag
    }

    fun removeFlag(flag: Int) {
        // &  ~
        mFlag = mFlag and flag.inv()
    }

    fun contains(flag: Int): Boolean {
        return mFlag and flag == flag
    }
}
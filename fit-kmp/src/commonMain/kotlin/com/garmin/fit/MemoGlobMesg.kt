/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MemoGlobMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class MemoGlobMesg : Mesg {

    companion object {
        const val PartIndexFieldNum = 250
        const val MemoFieldNum = 0
        const val MesgNumFieldNum = 1
        const val ParentIndexFieldNum = 2
        const val FieldNumFieldNum = 3
        const val DataFieldNum = 4

        val memoGlobMesg: Mesg = run {
            // memo_glob
            val memoGlobMesg = Mesg("memo_glob", MesgNum.MEMO_GLOB)
            memoGlobMesg.addField(Field("part_index", PartIndexFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            memoGlobMesg.addField(Field("memo", MemoFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            memoGlobMesg.addField(Field("mesg_num", MesgNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESG_NUM))
            memoGlobMesg.addField(Field("parent_index", ParentIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            memoGlobMesg.addField(Field("field_num", FieldNumFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            memoGlobMesg.addField(Field("data", DataFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            memoGlobMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MEMO_GLOB))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get part_index field
     * Comment: Sequence number of memo blocks
     *
     * @return part_index
     */
    fun getPartIndex(): Long? {
        return getFieldLongValue(250, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set part_index field
     * Comment: Sequence number of memo blocks
     *
     * @param partIndex The new partIndex value to be set
     */
    fun setPartIndex(partIndex: Long?) {
        setFieldValue(250, 0, partIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMemo(): Array<Byte?>? {
        return getFieldByteValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of memo
     */
    fun getNumMemo(): Int {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get memo field
     * Comment: Deprecated. Use data field.
     *
     * @param index of memo
     * @return memo
     */
    fun getMemo(index: Int): Byte? {
        return getFieldByteValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set memo field
     * Comment: Deprecated. Use data field.
     *
     * @param index of memo
     * @param memo The new memo value to be set
     */
    fun setMemo(index: Int, memo: Byte?) {
        setFieldValue(0, index, memo, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mesg_num field
     * Comment: Message Number of the parent message
     *
     * @return mesg_num
     */
    fun getMesgNum(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mesg_num field
     * Comment: Message Number of the parent message
     *
     * @param mesgNum The new mesgNum value to be set
     */
    fun setMesgNum(mesgNum: Int?) {
        setFieldValue(1, 0, mesgNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get parent_index field
     * Comment: Index of mesg that this glob is associated with.
     *
     * @return parent_index
     */
    fun getParentIndex(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set parent_index field
     * Comment: Index of mesg that this glob is associated with.
     *
     * @param parentIndex The new parentIndex value to be set
     */
    fun setParentIndex(parentIndex: Int?) {
        setFieldValue(2, 0, parentIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get field_num field
     * Comment: Field within the parent that this glob is associated with
     *
     * @return field_num
     */
    fun getFieldNum(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set field_num field
     * Comment: Field within the parent that this glob is associated with
     *
     * @param fieldNum The new fieldNum value to be set
     */
    fun setFieldNum(fieldNum: Short?) {
        setFieldValue(3, 0, fieldNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getData(): Array<Short?>? {
        return getFieldShortValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of data
     */
    fun getNumData(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data field
     * Comment: Block of utf8 bytes. Note, mutltibyte characters may be split across adjoining memo_glob messages.
     *
     * @param index of data
     * @return data
     */
    fun getData(index: Int): Short? {
        return getFieldShortValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data field
     * Comment: Block of utf8 bytes. Note, mutltibyte characters may be split across adjoining memo_glob messages.
     *
     * @param index of data
     * @param data The new data value to be set
     */
    fun setData(index: Int, data: Short?) {
        setFieldValue(4, index, data, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}

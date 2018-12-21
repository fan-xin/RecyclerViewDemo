package com.fanxin.android.recyclerviewdemo;

import java.util.List;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/19  14:48
 */
public class ImageData {


    /***
     * status:1
     * data:[{"id":1,"name":"xxxx"}]
     * msg:成功
     *
     */
    private int status;
    private String msg;
    private List<DataBean> data;

    //getter and setter
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    //内部类
    public static class DataBean{
        /***
         * id
         * name
         * picSmall
         * picBig
         * description
         * learner
         *
         */
        private int id;
        private String name;
        private String picSmall;
        private String picBig;
        private String description;
        private int leaner;

        //getter and setter

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicSmall() {
            return picSmall;
        }

        public void setPicSmall(String picSmall) {
            this.picSmall = picSmall;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getLeaner() {
            return leaner;
        }

        public void setLeaner(int leaner) {
            this.leaner = leaner;
        }

        public String getPicBig() {
            return picBig;
        }

        public void setPicBig(String picBig) {
            this.picBig = picBig;
        }
    }
}

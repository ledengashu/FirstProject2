package com.servlet;

import com.dao.GoodsDao;
import com.enity.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class GoodsInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errMsg = "";
        int rows = 0;
        try {
//            String goodsInfo_name = req.getParameter("goodsInfo_name");
//            String goodsInfo_price = req.getParameter("goodsInfo_price");
//            String goodsInfo_flag = req.getParameter("flag");
//            int flag;
//            if (goodsInfo_name==null ||
//                    "".equals(goodsInfo_name)){
//                throw new RuntimeException("商品名称不能为空");
//            }
//            if(goodsInfo_price==null ||
//                    "".equals(goodsInfo_price)){
//                throw new RuntimeException("商品价格不能为空");
//            }
//            if(goodsInfo_flag==null ||
//                    "".equals(goodsInfo_flag)){
//                flag = 0;
//            }else{
//                flag = Integer.parseInt(req.getParameter("flag"));
//            }
//
//            int price = Integer.parseInt(req.getParameter("goodsInfo_price"));
//            if(price<0){
//                throw new RuntimeException("商品价格不能为负数");
//            }
            //Goods goods = getGoodsByNormalForm(req);
            // 使用上传表单控件获得的学生对象
            Goods goods = this.uploadFile(req, resp);

//            if (goods.getGoodsInfo_name()==null ||
//                    "".equals(goods.getGoodsInfo_name())){
//                throw new RuntimeException("商品名称不能为空");
//            }
//            if(goods.getGoodsInfo_price()==0){
//                throw new RuntimeException("商品价格不能为空");
//            }

            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.goodsInsert(goods);
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if(rows>0){
            out.println("<script type='text/javascript'>alert('增加商品成功');location.href='goodsQueryServlet';</script>");
        }else{
            out.println("<script type='text/javascript'>alert('增加商品失败："+errMsg+"');history.back();</script>");

        }
    }

    private Goods getGoodsByNormalForm(HttpServletRequest req) {
        Goods goods = new Goods();
        goods.setGoodsInfo_name(req.getParameter("goodsInfo_name"));
        goods.setGoodsInfo_pic(req.getParameter("goodsInfo_pic"));
        goods.setGoodsInfo_price(Integer.parseInt(req.getParameter("goodsInfo_price")));
        goods.setGoodsInfo_description(req.getParameter("goodsInfo_description"));
        goods.setGoods_stock(req.getParameter("goods_stock"));
        goods.setFlag(Integer.parseInt(req.getParameter("flag")));
        return goods;
    }

    public Goods uploadFile(HttpServletRequest req,HttpServletResponse resp) throws FileUploadException, IOException {
        Goods goods = new Goods();
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        String errMsg = "";
//        try {
        if (isMultipart) {
            //上传表单：表示是enctype:multipart/form-data
            //1、判断当前表单是否为上传表单
            //2、如果是上传表单
            //  2.1、创建ServletFileUpload对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fileItemsList = upload.parseRequest(req);
            if (fileItemsList != null && fileItemsList.size() > 0) {
                for (FileItem fileItem : fileItemsList)
                    if (fileItem.isFormField()) {
                        if ("id".equals(fileItem.getFieldName())){
                            goods.setId(Integer.parseInt(fileItem.getString()));
                        }else if ("goodsInfo_name".equals(fileItem.getFieldName())) {
                            if (fileItem.getString("utf-8") == null || "".equals(fileItem.getString("utf-8"))) {
                                throw new RuntimeException("商品名称不能为空");
                            }
                            goods.setGoodsInfo_name(fileItem.getString("utf-8"));
                        } else if ("goodsInfo_price".equals(fileItem.getFieldName())) {
                            if (fileItem.getString() == null || "".equals(fileItem.getString())) {
                                throw new RuntimeException("商品价格不能为空");
                            }
                            if (Integer.parseInt(fileItem.getString()) < 0) {
                                throw new RuntimeException("商品价格不能为负数");
                            }
                            goods.setGoodsInfo_price(Integer.parseInt(fileItem.getString()));
                        } else if ("goodsInfo_description".equals(fileItem.getFieldName())) {
                            goods.setGoodsInfo_description(fileItem.getString("utf-8"));
                        } else if ("goods_stock".equals(fileItem.getFieldName())) {
                            goods.setGoods_stock(fileItem.getString("utf-8"));
                        } else if ("flag".equals(fileItem.getFieldName())) {
                            goods.setFlag(Integer.parseInt(fileItem.getString()));
                        }
                    } else {

                        try {
                            String fileName = fileItem.getName();
                            if (fileName == null) {
                                throw new RuntimeException("没有选择图片");
                            }
                            String parentPath = req.getServletContext().getRealPath("/upload");
                            File parentFile = new File(parentPath);
                            if (!parentFile.exists()) parentFile.mkdirs();
                            File newFile = new File(parentFile, fileName);
                            InputStream is = fileItem.getInputStream();
                            OutputStream os = new FileOutputStream(newFile);

                            IOUtils.copy(is, os);
                            os.close();
                            is.close();
                            goods.setGoodsInfo_pic(fileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                            //errMsg = e.getMessage();
                        }

                    }
            }
        } else {
            //普通表单
        }
//    } catch (Exception e) {
//            e.printStackTrace();
//            errMsg = e.getMessage();
//        }
//        if("".equals(errMsg)){
//        }else{
//            PrintWriter out = resp.getWriter();
//            out.println("<script type='text/javascript'>alert('新增商品失败："+errMsg+"');history.back();</script>");
//        }
        return goods;
    }
}

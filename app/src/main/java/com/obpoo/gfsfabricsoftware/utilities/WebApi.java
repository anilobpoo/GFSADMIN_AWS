package com.obpoo.gfsfabricsoftware.utilities;

import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deleteArticleRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.ViewRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AllPGrequest;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgRequest;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryRequest;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActRequest;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.FabricChangeRequest;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.TailorChangeRequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.AddCagRequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.addCagPOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticleRequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.deleteCmnartRequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticleDATA;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticlerequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.UpdateSMGmodel;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.updateSMGRequest;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ViewCompositionRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.StockAlertRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.StockSearchRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPORequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPORequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPoRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ModifyConfirmPoReq;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoOrderRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewConfirmPoRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewPgnRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.ReportRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Report_request;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricNameRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.ItemSalesRe.ItemSalesReq;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentReceivedRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PurchaseOrderDetailsrequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLogRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveCustomerRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabricSearchRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockShelvRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockZoneRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResReq;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDReq;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PasswareWareReq;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.TransferStockOutRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.TransferStockRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareReq;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleRequest;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleResponse;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartRequest;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.UpdateInvoRequest;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorRequest;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersRequest;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankRequest;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeRequest;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorResponse;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeRequest;
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeResponse;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupRequest;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxRequest;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderStatusReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSelectedStatusReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSoDateFilReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersRequest;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfRequest;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInRequest;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeRequest;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ViewShopRequest;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.ViewVendorsRequest;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeRequest;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseRequest;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneRequest;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WebApi {

    @POST("shop.php")
    Call<ShopResponse> shop(@Body ViewShopRequest request);

    @POST("vendor_type.php")
    Call<VendorTypeResponse> vendortype(@Body VendorTypeRequest request);

    @POST("vendor.php")
    Call<VendorsResponse> vendor(@Body ViewVendorsRequest request);

    @POST("customer_type.php")
    Call<CustomerTypeResponse> customertype(@Body CustomerTypeRequest request);

    @POST("customer.php")
    Call<CustomersResponse> customer(@Body CustomersRequest request);

    @POST("warehouse.php")
    Call<WarehouseResponse> warehouse(@Body WarehouseRequest request);

    @POST("bank_crud.php")
    Call<BankResponse> bank(@Body BankRequest request);

    @POST("minmax.php")
    Call<MinMaxResponse> minmax(@Body MinMaxRequest request);

    @POST("colors.php")
    Call<ColorResponse> color(@Body ColorRequest request);

    @POST("customer_group.php")
    Call<GroupResponse> group(@Body GroupRequest request);

    @POST("fabric_type.php")
    Call<FabricTypeResponse> fabrictype(@Body FabricTypeRequest request);

    @POST("ware_zone_shelf.php")
    Call<ZoneResponse> zone(@Body ZoneRequest request);

    @POST("ware_zone_shelf.php")
    Call<ShelfResponse> shelf(@Body ShelfRequest request);

    @POST("fabric.php")
    Call<FabricsResponse> fabrics(@Body FabricsRequest request);

    @POST("composition.php")
    Call<CompositionResponse> comp(@Body ViewCompositionRequest request);

    @POST("packaging_list.php")
    Call<BundleResponse> bundle(@Body BundleRequest request);

    @POST("get_shelves_barcode.php")
    Call<ShelfBarcodeResponse> bshelf(@Body ShelfBarcodeRequest request);

    @POST("po_req/fabric_stock.php")
    Call<StockInResponse> stockIn(@Body StockInRequest request);

    @POST("order/order.php")
    Call<MyOrdersResponse> order(@Body MyOrdersRequest request);

    @POST("order/order_items.php")
    Call<CartResponse> cart(@Body CartRequest request);


    //dijitha
    @POST("article_no.php")
    Call<stockPOJO> stocklistL(@Body ViewRequest request);

    @POST("article_no.php")
    Call<AddArticleResponse> AddArticleMsg(@Body AddArticleRequest request);

    @POST("fabric_type.php")
    Call<fabricTypePOJO> getFabricType(@Body com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.FabricTypeRequest request);

    @POST("article_no.php")
    Call<updateArticleResponse> updateArticle(@Body updateArticleRequest request);

    @POST("article_no.php")
    Call<deletearticelPOJO> deleteArticelAPI(@Body deleteArticleRequest request);

    @POST("article_common_api.php")
    Call<cmnArticlePOJO> cmnArticleAPI(@Body cmnArticleRequest request);

    @POST("article_common_api.php")
    Call<cmnArtdeletePOJO> deletecmnArticleAPI(@Body deleteCmnartRequest request);

    @POST("colors.php")
    Call<addCagPOJO> addCMGcolorAPI(@Body AddCagRequest request);

    @POST("article_common_api.php")
    Call<similarArticleDATA> similarArticleAddAPI(@Body similarArticlerequest request);

    @POST("article_common_api.php")
    Call<UpdateSMGmodel> similarArticleUpdateAPI(@Body updateSMGRequest request);

    @POST("admin_user.php")
    Call<UserResponse> viewAllUserList(@Body com.obpoo.gfsfabricsoftware.utilities.ViewRequest request);

    @POST("po_req/po_create_order.php")
    Call<poPOJO> viewPOApi(@Body ViewPgnRequest request);
  @POST("po_req/po_create_order.php")
    Call<poPOJO> viewPoOrderAPI(@Body PoOrderRequest request);

    @POST("po_req/po_create_order.php")
    Call<poPOJO> viewConfirmPOApi(@Body ViewConfirmPoRequest request);

    @POST("po_req/po_direct_order.php")
    Call<AddPoPojo> AddPO(@Body AddPORequest request);

    @POST("po_req/po_create_order.php")
    Call<ConfirmPOResponse> ConfirmPO(@Body ConfirmPoRequest request);
    @POST("po_req/po_order_items.php")
    Call<ConfirmPOResponse> ConfirmModifyPO(@Body ModifyConfirmPoReq request);

    @POST("pickup_guy/pickup_location.php")
    Call<NLData> NLAPI(@Body NLRequest request);

    @POST("color_code_list.php")
    Call<FabricColorResponse> fcolor(@Body FabricColorRequest request);

    @POST("pickup_guy/Test.php")
    Call<DeliveryData> AssignDeliveryAPI(@Body DeliveryRequest request);

    @POST("pickup_guy/pickup_user.php")
    Call<PGresponse> allPGapi(@Body AllPGrequest request);

    @POST("pickup_guy/Test.php")
    Call<AssignPgResponse> assignPGapi(@Body AssignPgRequest request);

    @POST("dashboard.php")
    Call<DashResponse> reportApi(@Body ReportRequest request);

    @GET("latest?")
    Call<RateResponse> retroEXrate(@Query("base") String base);

    @POST("stock_alert_pagn.php")
    Call<Response> reportApi(@Body StockAlertRequest request);

    @POST("ds_curve.php")
    Call<CurveResponse> curveApi(@Body CurveRequest request);

    @POST("stock_alert_pagn.php")
    Call<Response> stockSearchApi(@Body StockSearchRequest request);

    @POST("po_req/stock_of_wh_zone.php")
    Call<ViewStockResponse> viewStockWAPI(@Body ViewStockRequest request);

    @POST("po_req/stock_of_wh_zone.php")
    Call<ViewStockResponse> viewStockZAPI(@Body ViewStockZoneRequest request);

    @POST("po_req/stock_of_wh_zone_pgn.php")
    Call<ViewStockNewResponse> viewStockSAPI(@Body ViewStockShelvRequest request);

    @POST("fabric_timeline.php")
    Call<ActivityLogResponse> viewALAPI(@Body ActivityLogRequest request);

    @POST("show_fab_location.php")
    Call<FabSearchRes> viewFSAPI(@Body FabricSearchRequest request);

    @POST("transfer_module.php")
    Call<PendingOrderRes> pOIapi(@Body PendingOrderRequest request);

    @POST("transfer_module.php")
    Call<FabricPendingOIDRes> fabPOIapi(@Body FabricPendingOIDReq request);

    @POST("transfer_module.php")
    Call<TransferResponse> tranFabApi(@Body TransferRequest request);

    @POST("transfer_module.php")
    Call<TransferResponse> tranFabWareApi(@Body TransferWareRequest request);

    @POST("transfer_module.php")
    Call<TransferWareWareRes> tranFabWareWare(@Body TransferWareWareReq request);

    @POST("transfer_module.php")
    Call<TransferResponse> passWareWare(@Body PasswareWareReq request);

    @POST("customer_reserve.php")
    Call<CustomerResResp> customerResAPI(@Body CustomerResReq request);

    @POST("po_req/search.php")
    Call<AddReserveRes> addReserveapi(@Body AddReserveRequest request);

    @POST("customer_reserve.php")
    Call<AddCustomerReserveFinal> addCustomerReserveapi(@Body AddReserveCustomerRequest request);

    @POST("order/search_order.php")
    Call<Bill_Invoice_Response_data> billINvoiceAPI(@Body Bill_Invoice_Report_request request);

    @POST("customer/billing.php")
    Call<CustomerPendingResponse> customerPendAPI(@Body CustomerPendingRequest request);

    @POST("cutter/cut_stock.php")
    Call<CutStockResponse> cutStockAPI(@Body Bill_Invoice_Report_request request);

    @POST("fabric_analytics.php")
    Call<FabricAnalyticsResponse> fabricAnalyAPI(@Body Bill_Invoice_Report_request request);

    @POST("fabric.php")
    Call<FabricHistoryResponse> fabricNameAPI(@Body FabricNameRequest request);

    @POST("fabric_ordered_by_po.php")
    Call<FabricGraphResponse> fabricHistoryAPI(@Body FabricHistoryRequest request);

    @POST("all_payments_rcvd.php")
    Call<PaymentRecResponse> paymentRecAPI(@Body PaymentReceivedRequest request);

    @POST("po_req/packaging_list.php")
    Call<PoDetailsresponse> podetApi(@Body PurchaseOrderDetailsrequest request);

    @POST("current_date_fabrics.php")
    Call<PO_Fabric_Response> poFabricListAPI(@Body Bill_Invoice_Report_request request);

    @POST("po_req/po_leftovers.php")
    Call<POleftOverResponse> poleftoverAPI(@Body PaymentReceivedRequest request);

    @POST("check_in_out.php")
    Call<CheckInResponse> pocheckINAPI(@Body PaymentReceivedRequest request);

    @POST("check_in_out.php")
    Call<CheckOutResponse> pocheckIOUTAPI(@Body PaymentReceivedRequest request);

    @POST("current_date_fabrics.php")
    Call<SoldFabricsResponse> soldFabricAPI(@Body Bill_Invoice_Report_request request);

    @POST("transfer_stock_document.php")
    Call<Ts_Response> tranFabcAPI(@Body TransferStockRequest request);

    @POST("transfer_stock_document.php")
    Call<TransferResponse> tranStockOutFabcAPI(@Body TransferStockOutRequest request);

    @POST("associate_fabric.php")
    Call<ATresponse> atAPI(@Body com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewRequest request);

    @POST("associate_fabric.php")
    Call<AssociateActivity> assoACTAPI(@Body AssociateActRequest request);

    @POST("associate_fabric.php")
    Call<AssociateActivity> assotailorChangeReqAPI(@Body TailorChangeRequest request);

    @POST("associate_fabric.php")
    Call<AssoFabricResponse> assoFABAPI(@Body com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewRequest request);

    @POST("associate_order.php")
    Call<AssociateFabricChangeURL> assoFABchangeURL(@Body com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewRequest request);

    @POST("associate_order.php")
    Call<AssociateFabircChangeRes> assoFABchangeAPI(@Body FabricChangeRequest request);

    @POST("roles.php")
    Call<PreviledgesResponse> retroPreviledges(@Body PreviledgesRequest request);

    @POST("customer.php")
    Call<TrackPOByCusRes> trackPOAPI(@Body TrackPORequest request);
    @POST("po_req/po_create_order.php")
    Call<TrackPODetRes> trackPODetApi(@Body TrackPODetRequest request);
    @POST("order/order.php")
    Call<AllOrderRes> allorderSOAPI(@Body AllORderReq request);
    @POST("order/order.php")
    Call<AllOrderRes> allorderSODateFilAPI(@Body AllOrderSoDateFilReq request);
    @POST("order/order_status_master.php")
    Call<AllOrderStatusRes> allorderSOstatusAPI(@Body AllORderStatusReq request);
    @POST("order/order.php")
    Call<AllOrderRes> allorderSOstatusselectedAPI(@Body AllOrderSelectedStatusReq request);

    @POST("pickup_guy/pg_collections.php")
    Call<CollectionsDResponse> CollectionDetApi(@Body CollectionsDRequest request);

    @POST("pickup_guy/pg_collections.php")
    Call<CollectionInvoiceResponse> CollectionInvoApi(@Body InvoiceRequest request);
    @POST("pickup_guy/pg_collections.php")
    Call<CollectionInvoiceResponse> updateInvoApi(@Body UpdateInvoRequest request);
    @POST("pickup_guy/match_deposit_otp.php")
    Call<DepositeResponse> depositeCollectionsApi(@Body DepositeRequest request);
    @POST("order/order_Report.php")
    Call<SoldFabricsResponse> itemSalesApi(@Body ItemSalesReq request);
}

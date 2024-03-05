### TODO: A utility class which will be created by the user , with Class name as " _[your roll number]" ,
# TODO: all transformations should be written inside a function which will be called inside the predict method
import pandas as pd
import pickle
import numpy as np

class _1705242():

    ## TODO: Please note that document id should be present till the getPredictions method
    def __tranformation1(self,data):

        # your transformation logic goes here
        data['document_create_date'] = pd.to_datetime(data.document_create_date)
        data['doc_create_year'] = data.document_create_date.dt.year
        data['doc_create_month'] = data.document_create_date.dt.month
        data['doc_create_day'] = data.document_create_date.dt.day
        data['doc_create_weekday'] = data.document_create_date.dt.dayofweek
        return data

    def __transformation2(self,data):
        data['invoice_currency_log'] = data['invoice_amount_doc_currency'].transform(lambda x: np.log(x/2+1))
        enc = {'ABC Softwares': 0, 'ABSTERGO INDUSTRIES': 1, 'AT&T': 2, 'CZERKA CORP': 3, 'Cyberdyne Systems Corporation': 4,
 'ERT companies': 5, 'EVIL CORP': 6, 'Fatboy Industries': 7, 'HYPERION CORPORATION': 8, 'LEXCORP': 9, 'OMNI CONSUMER PRODUCTS ': 10,
 'PAGE INDUSTRIES': 11, 'Pathak networks': 12, 'PiperChat': 13, 'Primatech industries': 14, 'RUPTURE FARMS': 15, 'Soylent Corporation': 16,
 'Tyrell Corporation': 17, 'UMBRELLA CORP': 18, 'VERIDIAN DYNAMICS': 19, 'Veidt Industries': 20, 'WOLFRAM AND HART': 21, 'Weyland-Yutani corp': 22,
 'arp softwares': 23, 'aviato': 24, 'bochmanedy': 25, 'chatmet': 26, 'codeU': 27, 'cvMaker corp': 28, 'deep scraper': 29, 'end frame': 30, 'hooli': 31,
 'hooli xyz': 32, 'johnsons and johnsons': 33, 'kais corp': 34, 'mdassist pvt ltd': 35, 'medi help corporation': 36, 'media tech': 37, 'middle man inc': 38,
 'nucleus': 39, 'p&g': 40, 'pied piper': 41, 'randstad': 42, 'raviga capital': 43, 'sam kaiser': 44, 'see food': 45, 'skynetpwc softwares': 46,
 'system ops': 47, 'walmart': 48, 'wtf foods': 49, 'xyz softwares': 50}
        temp = data.customer_name
        data['encoded_names'] = [enc[x] for x in temp]
        data['days_past_duedate'] = data['dayspast_due']
        data['age_invoice'] = data['invoice_age']
        try:
              data['Shipping_avail'] = data.ship_date.isnull().astype(int)
        except:
              data['Shipping_avail'] = 0
        # your transformation logic goes here
        return data
    def __payment_type(self, data):
        lis = data['actual_open_amount']*0.9 <= data['predictions']
        li = []
        for i in lis:
             if(i):
                  li.append("Full payment")
             else:
                  li.append("partial payment")
        print(li)
        return li
    def getPredictions(self,data,model):
        data = self.__tranformation1(data)
        data = self.__transformation2(data)
        # your feature list, column names
        features = ['days_past_duedate', 'age_invoice', 'invoice_currency_log','doc_create_year', 'doc_create_month', 'doc_create_day','doc_create_weekday', 'encoded_names', 'Shipping_avail']
        print(data[features])
        # data should be a dataFrame and not a numpy array
        predictions = model.predict(data[features])
        data['predictions'] = predictions
        data['payment_type'] = self.__payment_type(data)
        pred = data.loc[:,['acct_doc_header_id','actual_open_amount','predictions','payment_type']].to_dict(orient="records")
        return pred

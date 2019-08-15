
app-guest:
1. http --form POST localhost:8100/oauth/token Authorization:"Basic Z3Vlc3QtYXBwOnNlY3JldA==" grant_type=client_credentials
2. http --form localhost:8100/oauth/check_token Authorization:"Bearer 9aa368c0-5e92-42ae-b300-4b2981060b25" token=9aa368c0-5e92-42ae-b300-4b2981060b25

api-client:
3. http --form POST localhost:8100/oauth/token Authorization:"Basic YXBpLWF1ZGl0OnNlY3JldA==" grant_type=client_credentials
4. http --form localhost:8100/oauth/check_token Authorization:"Bearer 4fdef6cb-0a2e-42df-ae91-97d325ab1b7d" token=4fdef6cb-0a2e-42df-ae91-97d325ab1b7d

convert client name and secret (refer AuthorizationServerConfig) using URL:
http://www.tuxgraphics.org/toolbox/base64-javascript.html

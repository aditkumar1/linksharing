<div class="modal fade" id="documentShare" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="background-color:#D3D3D3">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group">

                        <label for="inputEmail" class="control-label col-xs-2">Document*</label>

                        <div class="col-xs-5">

                            <input type="email" class="form-control" id="inputEmail">

                        </div>

                        <div class="col-xs-5">

                            <button class="form-control" style="background-color:#D3D3D3">Browse</button>

                        </div>

                    </div>

                    <div class="form-group">

                        <label for="inputEmail" class="control-label col-xs-2">Description*</label>

                        <div class="col-xs-10">

                            <textarea class="form-control" placeholder="Description">
                            </textarea>
                        </div>

                    </div>

                    <div class="form-group">

                        <label for="documentTopicSelect" class="control-label col-xs-2">Topic*</label>

                        <div class="col-xs-10">

                            <g:select class="form-control" id="documentTopicSelect" name="topicSelect" from="${subscribedTopics}"></g:select>

                        </div>

                    </div>


                    <div class="form-group">

                        <div class="col-xs-offset-2 col-xs-10">

                            <button type="submit" class="btn btn-primary">Share</button>
                            <button type="submit" class="btn btn-primary">Cancel</button>

                        </div>

                    </div>

                </form>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="documentShare" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="background-color:#D3D3D3">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>

            <div class="modal-body">
                <g:uploadForm controller="documentResource" action="save" class="form-horizontal">


                    <div class="form-group">

                        <label for="file" class="control-label col-xs-2">Document*</label>

                        <div class="col-xs-10">
                            <input type="file" id="file" name="file" style="background-color:#D3D3D3"/>
                        </div>

                    </div>

                    <div class="form-group">

                        <label for="inputDescription" class="control-label col-xs-2">Description*</label>

                        <div class="col-xs-10">

                            <g:textArea name="description" class="form-control" id="inputDescription" placeholder="description">
                            </g:textArea>
                        </div>

                    </div>

                    <div class="form-group">

                        <label for="documentTopicSelect" class="control-label col-xs-2">Topic*</label>

                        <div class="col-xs-10">

                            <g:select class="form-control" id="documentTopicSelect" name="topicId" optionKey="id" from="${subscribedTopics}"></g:select>

                        </div>

                    </div>


                    <div class="form-group">

                        <div class="col-xs-offset-2 col-xs-10">

                            <g:submitButton name="documentSubmit" type="submit" class="btn btn-primary">Share</g:submitButton>
                            <button  class="btn btn-default" data-dismiss="modal">Cancel</button>

                        </div>

                    </div>

                </g:uploadForm>
            </div>

        </div>
    </div>
</div>